package com.phonepe.cricket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.phonepe.cricket.constant.Constant;
import com.phonepe.cricket.exceptions.CricketAppException;
import com.phonepe.cricket.executors.BallExecutorFactory;
import com.phonepe.cricket.factory.Ball;
import com.phonepe.cricket.factory.BallFactory;
import com.phonepe.cricket.handler.BattingOrderHandler;
import com.phonepe.cricket.handler.IBattingOrderHandler;
import com.phonepe.cricket.handler.IScoreCardHandler;
import com.phonepe.cricket.handler.ScoreCardHandler;
import com.phonepe.cricket.model.match.Match;
import com.phonepe.cricket.model.match.Over;
import com.phonepe.cricket.model.match.Team;
import com.phonepe.cricket.repository.IMatchRepository;
import com.phonepe.cricket.repository.IPlayerRepository;
import com.phonepe.cricket.repository.ITeamRepository;
import com.phonepe.cricket.repository.MatchRepository;
import com.phonepe.cricket.service.IMatchService;
import com.phonepe.cricket.service.ITeamService;
import com.phonepe.cricket.service.MatchService;
import com.phonepe.cricket.service.TeamService;

public class CricketApplication {

	// 5 2
	// P1 P2 P3 P4 P5 1 1 1 1 1 2 W 4 4 Wd W 1 6
	// P6 P7 P8 P9 P10 4 6 W W 1 1 6 1 W W

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);

		final ITeamRepository teamRepository = new ITeamRepository();
		final TeamService teamService = new ITeamService(teamRepository);

		final IPlayerRepository playerRepository = new IPlayerRepository();

		final BallFactory ballFactory = new BallFactory();
		final BallExecutorFactory ballExecutorFactory = new BallExecutorFactory();

		final MatchRepository matchRepository = new IMatchRepository();
		final MatchService matchService = new IMatchService(matchRepository, ballExecutorFactory);
		final ScoreCardHandler scoreCardHandler = new IScoreCardHandler(matchRepository);

		final BattingOrderHandler battingOrderHandler = new IBattingOrderHandler(teamRepository, playerRepository);

		System.out.print("No. of players for each team: ");
		int teamSize = scanner.nextInt();
		System.out.print("No. of overs: ");
		int overs = scanner.nextInt();

		try {

			final Team team1 = teamService.createTeam(Integer.toString(1), teamSize);
			final Team team2 = teamService.createTeam(Integer.toString(2), teamSize);
			List<Team> teams = Arrays.asList(team1, team2);
			final Match match = matchService.createMatch("Match 1", teams, overs);

			for (int teamIdx = 0; teamIdx < Constant.TOTAL_TEAMS_IN_A_MATCH; teamIdx++) {
				final Team team = teams.get(teamIdx);
				System.out.println("Batting Order for team " + team.getName() + ":");
				final List<String> playersId = new ArrayList<>();
				for (int playerIdx = 0; playerIdx < teamSize; playerIdx++) {
					playersId.add(scanner.next());
				}
				battingOrderHandler.initBattingOrder(team.getName(), playersId);
				for (int over = 1; over <= overs; over++) {
					match.getCurrentInning().addOver(new Over(overs));
					System.out.println("Over " + match.getCurrentInning().getOvers().size() + ":");
					boolean isAllOut = false;
					boolean isWon = false;
					while (!match.getCurrentInning().getCurrentOver().isFinished()) {
						final Ball ball = ballFactory.getBall(scanner.next());
						matchService.addBall(match.getId(), ball);
						if (match.getCurrentInning().getTeam().isAllOut()) {
							isAllOut = true;
							break;
						}
						if (teamIdx == 1) {
							final int currentTeamScore = team.getExtras() + team.getScores();
							final Team previousTeam = teams.get(teamIdx - 1);
							final int previousTeamScore = previousTeam.getExtras() + previousTeam.getScores();
							if (currentTeamScore > previousTeamScore) {
								isWon = true;
								break;
							}
						}
					}
					System.out.println(scoreCardHandler.getScoreCard(match.getId()));
					if (isAllOut || isWon) {
						break;
					}
				}
				match.incrementCurrentInningIdx();
			}

			System.out.println(scoreCardHandler.getMatchResult(match.getId()));

		} catch (final CricketAppException exception) {
			System.err.println(exception);
		}

		scanner.close();
	}

}
