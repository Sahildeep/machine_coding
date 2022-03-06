package com.phonepe.cricket.repository;

import java.util.List;

import com.phonepe.cricket.exceptions.TeamAlreadyExistsException;
import com.phonepe.cricket.exceptions.TeamDoesNotExistException;
import com.phonepe.cricket.model.match.Team;
import com.phonepe.cricket.model.user.Coach;
import com.phonepe.cricket.model.user.Player;

import lombok.NonNull;

public interface TeamRepository {

	Team createTeam(@NonNull final String teamName, @NonNull final int teamSize) throws TeamAlreadyExistsException;

	Team getTeam(@NonNull final String teamName) throws TeamDoesNotExistException;

	Coach addCoach(@NonNull final String teamName, @NonNull final Coach coach) throws TeamDoesNotExistException;

	List<Player> getAllPlayers(String teamName) throws TeamDoesNotExistException;

	boolean addPlayers(@NonNull final String teamName, @NonNull final List<Player> players)
			throws TeamDoesNotExistException;

}
