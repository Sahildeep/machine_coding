package com.phonepe.cricket.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.phonepe.cricket.exceptions.TeamAlreadyExistsException;
import com.phonepe.cricket.exceptions.TeamDoesNotExistException;
import com.phonepe.cricket.model.match.Team;
import com.phonepe.cricket.model.user.Coach;
import com.phonepe.cricket.model.user.Player;

import lombok.NonNull;

public class ITeamRepository implements TeamRepository {

	private final Map<String, Team> teamMap;

	public ITeamRepository() {
		this.teamMap = new HashMap<>();
	}

	@Override
	public Team createTeam(@NonNull final String teamName, @NonNull final int teamSize)
			throws TeamAlreadyExistsException {
		if (teamMap.containsKey(teamName)) {
			throw new TeamAlreadyExistsException("Team " + teamName + " already exists.");
		}
		final Team team = new Team(teamName, teamSize);
		teamMap.put(teamName, team);
		return team;
	}

	@Override
	public boolean addPlayers(@NonNull final String teamName, @NonNull final List<Player> players)
			throws TeamDoesNotExistException {
		if (!teamMap.containsKey(teamName)) {
			throw new TeamDoesNotExistException("Team " + teamName + " does not exist.");
		}
		teamMap.get(teamName).setPlayers(players);
		return true;
	}

	@Override
	public Coach addCoach(@NonNull final String teamName, @NonNull final Coach coach) throws TeamDoesNotExistException {
		if (!teamMap.containsKey(teamName)) {
			throw new TeamDoesNotExistException("Team " + teamName + " does not exist.");
		}
		teamMap.get(teamName).setCoach(coach);
		return coach;
	}

	@Override
	public List<Player> getAllPlayers(final String teamName) throws TeamDoesNotExistException {
		if (!teamMap.containsKey(teamName)) {
			throw new TeamDoesNotExistException("Team " + teamName + " does not exist.");
		}
		return teamMap.get(teamName).getPlayers();
	}

	@Override
	public Team getTeam(@NonNull final String teamName) throws TeamDoesNotExistException {
		if (!teamMap.containsKey(teamName)) {
			throw new TeamDoesNotExistException("Team " + teamName + " does not exist.");
		}
		return teamMap.get(teamName);
	}

}
