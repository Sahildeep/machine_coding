package com.phonepe.cricket.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.phonepe.cricket.exceptions.MatchAlreadyExistsException;
import com.phonepe.cricket.exceptions.MatchDoesNotExistException;
import com.phonepe.cricket.model.match.Match;
import com.phonepe.cricket.model.match.Team;

import lombok.NonNull;

public class IMatchRepository implements MatchRepository {

	private final Map<String, Match> matchMap;

	public IMatchRepository() {
		this.matchMap = new HashMap<>();
	}

	@Override
	public Match createMatch(@NonNull final String matchId, @NonNull final List<Team> teams, @NonNull final int overs)
			throws MatchAlreadyExistsException {
		if (matchMap.containsKey(matchId)) {
			throw new MatchAlreadyExistsException("Match " + matchId + " already exists");
		}
		final Match match = new Match(matchId, teams, overs);
		matchMap.put(matchId, match);
		return match;
	}

	@Override
	public Match getMatch(@NonNull final String matchId) throws MatchDoesNotExistException {
		if (!matchMap.containsKey(matchId)) {
			throw new MatchDoesNotExistException("Match " + matchId + " does not exist");
		}
		return matchMap.get(matchId);
	}

}
