package com.phonepe.cricket.repository;

import com.phonepe.cricket.exceptions.PlayerAlreadyExistsException;
import com.phonepe.cricket.exceptions.PlayerDoesNotExistException;
import com.phonepe.cricket.model.user.Player;

import lombok.NonNull;

public interface PlayerRepository {

	// Add Other Metadata
	Player addPlayer(@NonNull final String id) throws PlayerAlreadyExistsException;

	Player removePlayer(@NonNull final String id) throws PlayerDoesNotExistException;
	
	Player getPlayer(@NonNull final String id) throws PlayerDoesNotExistException;

}
