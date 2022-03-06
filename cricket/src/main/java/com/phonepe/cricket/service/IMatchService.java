package com.phonepe.cricket.service;

import java.util.List;

import com.phonepe.cricket.exceptions.MatchAlreadyExistsException;
import com.phonepe.cricket.exceptions.MatchDoesNotExistException;
import com.phonepe.cricket.executors.BallExecutorFactory;
import com.phonepe.cricket.factory.Ball;
import com.phonepe.cricket.model.match.Match;
import com.phonepe.cricket.model.match.Team;
import com.phonepe.cricket.repository.MatchRepository;

import lombok.NonNull;

public class IMatchService implements MatchService {

	private final MatchRepository matchRepository;
	private final BallExecutorFactory ballExecutorFactory;

	public IMatchService(@NonNull final MatchRepository matchRepository,
			@NonNull final BallExecutorFactory ballExecutorFactory) {
		this.matchRepository = matchRepository;
		this.ballExecutorFactory = ballExecutorFactory;
	}

	@Override
	public Match createMatch(@NonNull final String matchId, @NonNull final List<Team> teams, @NonNull final int overs)
			throws MatchAlreadyExistsException {
		return matchRepository.createMatch(matchId, teams, overs);
	}

	@Override
	public Match getMatch(@NonNull final String matchId) throws MatchDoesNotExistException {
		return matchRepository.getMatch(matchId);
	}

	@Override
	public void addBall(@NonNull String matchId, @NonNull Ball ball) throws MatchDoesNotExistException {
		final Match match = matchRepository.getMatch(matchId);
		ballExecutorFactory.executeBall(match, ball);
	}

}
