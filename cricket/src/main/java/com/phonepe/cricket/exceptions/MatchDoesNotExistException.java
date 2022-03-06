package com.phonepe.cricket.exceptions;

import lombok.NonNull;

public class MatchDoesNotExistException extends CricketAppException {

	private static final long serialVersionUID = 3317153519143221124L;

	public MatchDoesNotExistException(@NonNull final String errorMessage) {
		super(errorMessage);
	}

}
