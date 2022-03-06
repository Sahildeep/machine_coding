package com.phonepe.cricket.exceptions;

import lombok.NonNull;

public class PlayerAlreadyExistsException extends CricketAppException {

	private static final long serialVersionUID = 518272415103305952L;

	public PlayerAlreadyExistsException(@NonNull final String errorMessage) {
		super(errorMessage);
	}

}
