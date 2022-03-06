package com.phonepe.cricket.handler;

import java.util.List;

import com.phonepe.cricket.exceptions.PlayerAlreadyExistsException;
import com.phonepe.cricket.exceptions.TeamDoesNotExistException;
import com.phonepe.cricket.model.user.Player;

import lombok.NonNull;

public interface BattingOrderHandler {

	List<Player> initBattingOrder(@NonNull final String teamName, @NonNull final List<String> playersId)
			throws PlayerAlreadyExistsException, TeamDoesNotExistException;

}
