package com.phonepe.cricket.repository;

import java.util.HashMap;
import java.util.Map;

import com.phonepe.cricket.exceptions.PlayerAlreadyExistsException;
import com.phonepe.cricket.exceptions.PlayerDoesNotExistException;
import com.phonepe.cricket.model.user.Player;

import lombok.NonNull;

public class IPlayerRepository implements PlayerRepository {

	private final Map<String, Player> playerMap;

	public IPlayerRepository() {
		this.playerMap = new HashMap<>();
	}

	@Override
	public Player addPlayer(@NonNull final String id) throws PlayerAlreadyExistsException {
		if (playerMap.containsKey(id)) {
			throw new PlayerAlreadyExistsException("Player " + id + " already exists.");
		}
		final Player player = new Player(id);
		player.setName(id);
		playerMap.put(id, player);
		return player;
	}

	@Override
	public Player removePlayer(@NonNull final String id) throws PlayerDoesNotExistException {
		if (!playerMap.containsKey(id)) {
			throw new PlayerDoesNotExistException("Player " + id + " does not exist.");
		}
		final Player player = playerMap.get(id);
		playerMap.remove(id);
		return player;
	}

	@Override
	public Player getPlayer(@NonNull final String id) throws PlayerDoesNotExistException {
		if (!playerMap.containsKey(id)) {
			throw new PlayerDoesNotExistException("Player " + id + " does not exist.");
		}
		return playerMap.get(id);
	}

}
