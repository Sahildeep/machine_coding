package com.phonepe.cricket.service;

import com.phonepe.cricket.exceptions.PlayerAlreadyExistsException;
import com.phonepe.cricket.exceptions.PlayerDoesNotExistException;
import com.phonepe.cricket.model.user.Player;
import com.phonepe.cricket.repository.PlayerRepository;

import lombok.NonNull;

public class IPlayerService implements PlayerService {

	private final PlayerRepository playerRepository;

	public IPlayerService(@NonNull final PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@Override
	public Player addPlayer(@NonNull final String id) throws PlayerAlreadyExistsException {
		return playerRepository.addPlayer(id);
	}

	@Override
	public Player removePlayer(@NonNull final String id) throws PlayerDoesNotExistException {
		return playerRepository.removePlayer(id);
	}

	@Override
	public Player getPlayer(@NonNull final String id) throws PlayerDoesNotExistException {
		return playerRepository.getPlayer(id);
	}

}
