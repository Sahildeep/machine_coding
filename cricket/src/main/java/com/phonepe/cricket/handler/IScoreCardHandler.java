package com.phonepe.cricket.handler;

import java.util.List;

import com.phonepe.cricket.exceptions.MatchDoesNotExistException;
import com.phonepe.cricket.model.match.Match;
import com.phonepe.cricket.model.match.Over;
import com.phonepe.cricket.model.match.Team;
import com.phonepe.cricket.model.user.Player;
import com.phonepe.cricket.repository.MatchRepository;

import lombok.NonNull;

public class IScoreCardHandler implements ScoreCardHandler {

	private final MatchRepository matchRepository;

	public IScoreCardHandler(@NonNull final MatchRepository matchRepository) {
		this.matchRepository = matchRepository;
	}

	@Override
	public String getScoreCard(@NonNull final String matchId) throws MatchDoesNotExistException {
		final Match match = matchRepository.getMatch(matchId);
		final Team team = match.getCurrentInning().getTeam();
		return getScoreCard(team);
	}

	private String getScoreCard(@NonNull final Team team) {
		final StringBuilder scoreCard = new StringBuilder();
		scoreCard.append("Scorecard for Team " + team.getName() + ":\n");
		scoreCard.append("Player Name\tScore\t4s\t6s\tBalls\tStrike Rate\n");
		int totalScore = 0;
		int ballsPlayed = 0;
		for (int playerIdx = 0; playerIdx < team.getPlayers().size(); playerIdx++) {
			final Player player = team.getPlayers().get(playerIdx);
			boolean isActive = playerIdx == team.getStrikerIdx() || playerIdx == team.getNonStrikerIdx();
			double strikeRate = 0.0;
			if (player.getBallsPlayed() != 0) {
				strikeRate = ((double) player.getScore() / player.getBallsPlayed()) * 100;
			}
			scoreCard.append(player.getName() + (isActive ? "*" : "") + "\t\t" + player.getScore() + "\t"
					+ player.getFours() + "\t" + player.getSixes() + "\t" + player.getBallsPlayed() + "\t"
					+ String.format("%.2f", strikeRate) + "\n");
			totalScore += player.getScore();
			ballsPlayed += player.getBallsPlayed();
		}
		scoreCard.append("Total: " + (totalScore + team.getExtras()) + "/" + team.getOuts() + "\n");
		scoreCard.append("Extras: " + team.getExtras() + "\n");
		scoreCard.append("Overs: " + ballsPlayed / 6 + "." + ballsPlayed % 6);
		return scoreCard.toString();
	}

	@Override
	public String getMatchResult(@NonNull final String matchId) throws MatchDoesNotExistException {
		final Match match = matchRepository.getMatch(matchId);
		final Team team1 = match.getInnings().get(0).getTeam();
		final Team team2 = match.getInnings().get(1).getTeam();
		final int team1Score = team1.getExtras() + team1.getScores();
		final int team2Score = team2.getExtras() + team2.getScores();
		String result = "Drawn";
		match.drawnMatch();
		if (team1Score > team2Score) {
			result = "Team " + team1.getName() + " won the match by " + (team1Score - team2Score) + " runs";
			match.finishedMatch();
		} else if (team1Score < team2Score) {
			result = "Team " + team2.getName() + " won the match by " + (team2.getSize() - team2.getOuts())
					+ " wickets";
			match.finishedMatch();
		}
		return result;
	}

	@Override
	public String getOverRecords(@NonNull String matchId) throws MatchDoesNotExistException {
		final Match match = matchRepository.getMatch(matchId);
		final List<Over> overs = match.getCurrentInning().getOvers();

		final StringBuilder bowlerRecord = new StringBuilder();
		bowlerRecord.append("Over\tRuns conceded\tWickets taken\tDot balls\tEconomy\n");
		for (int overIdx = 0; overIdx < overs.size(); overIdx++) {
			final Over over = overs.get(overIdx);
			final int runs = over.getRunsConceded();
			final int wickets = over.getWickets();
			final int dotBalls = over.getDotBalls();
			bowlerRecord.append(
					"O" + (overIdx + 1) + "\t" + runs + "\t\t" + wickets + "\t\t" + dotBalls + "\t\t" + runs + "\n");
		}

		return bowlerRecord.toString();
	}

}
