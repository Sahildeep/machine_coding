package com.phonepe.cricket.service;

import java.util.List;

import com.phonepe.cricket.exceptions.TeamAlreadyExistsException;
import com.phonepe.cricket.exceptions.TeamDoesNotExistException;
import com.phonepe.cricket.model.match.Team;
import com.phonepe.cricket.model.user.Coach;
import com.phonepe.cricket.model.user.Player;
import com.phonepe.cricket.repository.TeamRepository;

import lombok.NonNull;

public class ITeamService implements TeamService {

	private final TeamRepository teamRepository;

	public ITeamService(@NonNull final TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	@Override
	public Team createTeam(@NonNull final String teamName, @NonNull final int teamSize)
			throws TeamAlreadyExistsException {
		return teamRepository.createTeam(teamName, teamSize);
	}

	@Override
	public boolean addPlayer(@NonNull final String teamName, @NonNull final List<Player> players)
			throws TeamDoesNotExistException {
		return teamRepository.addPlayers(teamName, players);
	}

	@Override
	public Coach addCoach(@NonNull final String teamName, @NonNull final Coach coach) throws TeamDoesNotExistException {
		return teamRepository.addCoach(teamName, coach);
	}

	@Override
	public List<Player> getAllPlayers(@NonNull final String teamName) throws TeamDoesNotExistException {
		return teamRepository.getAllPlayers(teamName);
	}

}
