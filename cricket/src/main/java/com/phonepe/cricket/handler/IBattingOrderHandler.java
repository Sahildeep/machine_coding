package com.phonepe.cricket.handler;

import java.util.ArrayList;
import java.util.List;

import com.phonepe.cricket.exceptions.PlayerAlreadyExistsException;
import com.phonepe.cricket.exceptions.TeamDoesNotExistException;
import com.phonepe.cricket.model.user.Player;
import com.phonepe.cricket.repository.PlayerRepository;
import com.phonepe.cricket.repository.TeamRepository;

import lombok.NonNull;

public class IBattingOrderHandler implements BattingOrderHandler {

	private final TeamRepository teamRepository;
	private final PlayerRepository playerRepository;

	public IBattingOrderHandler(@NonNull final TeamRepository teamRepository,
			@NonNull final PlayerRepository playerRepository) {
		this.teamRepository = teamRepository;
		this.playerRepository = playerRepository;
	}

	@Override
	public List<Player> initBattingOrder(@NonNull final String teamName, @NonNull final List<String> playersId)
			throws PlayerAlreadyExistsException, TeamDoesNotExistException {
		final List<Player> players = new ArrayList<>();
		for (final String playerId : playersId) {
			final Player player = playerRepository.addPlayer(playerId);
			players.add(player);
		}
		teamRepository.addPlayers(teamName, players);
		return players;
	}

}
