package com.phonepe.cricket.exceptions;

import lombok.NonNull;

public class MatchAlreadyExistsException extends CricketAppException {

	private static final long serialVersionUID = 7378549136164229539L;

	public MatchAlreadyExistsException(@NonNull final String errorMessage) {
		super(errorMessage);
	}

}
