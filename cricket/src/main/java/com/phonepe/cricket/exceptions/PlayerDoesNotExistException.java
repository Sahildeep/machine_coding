package com.phonepe.cricket.exceptions;

import lombok.NonNull;

public class PlayerDoesNotExistException extends CricketAppException {

	private static final long serialVersionUID = 8306145121567608934L;

	public PlayerDoesNotExistException(@NonNull final String errorMessage) {
		super(errorMessage);
	}

}
