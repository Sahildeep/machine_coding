package com.phonepe.cricket.handler;

import com.phonepe.cricket.exceptions.MatchDoesNotExistException;
import com.phonepe.cricket.model.match.Match;
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
		StringBuilder scoreCard = new StringBuilder();
		scoreCard.append("Scorecard for Team " + team.getName() + ":\n");
		scoreCard.append("Player Name\tScore\t4s\t6s\tBalls\n");
		int totalScore = 0;
		int ballsPlayed = 0;
		for (int playerIdx = 0; playerIdx < team.getPlayers().size(); playerIdx++) {
			final Player player = team.getPlayers().get(playerIdx);
			boolean isActive = playerIdx == team.getStrikerIdx() || playerIdx == team.getNonStrikerIdx();
			scoreCard.append(player.getName() + (isActive ? "*" : "") + "\t\t" + player.getScore() + "\t"
					+ player.getFours() + "\t" + player.getSixes() + "\t" + player.getBallsPlayed() + "\n");
			totalScore += player.getScore();
			ballsPlayed += player.getBallsPlayed();
		}
		scoreCard.append("Total: " + (totalScore + team.getExtras()) + "/" + team.getOuts() + "\n");
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

}
