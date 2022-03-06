package com.phonepe.cricket.repository;

import java.util.List;

import com.phonepe.cricket.exceptions.MatchAlreadyExistsException;
import com.phonepe.cricket.exceptions.MatchDoesNotExistException;
import com.phonepe.cricket.model.match.Match;
import com.phonepe.cricket.model.match.Team;

import lombok.NonNull;

public interface MatchRepository {

	Match getMatch(@NonNull final String matchId) throws MatchDoesNotExistException;

	Match createMatch(@NonNull String matchId, @NonNull List<Team> teams, @NonNull int overs)
			throws MatchAlreadyExistsException;

}
