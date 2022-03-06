package com.phonepe.cricket.exceptions;

import lombok.NonNull;

public class TeamDoesNotExistException extends CricketAppException {

	private static final long serialVersionUID = -8017502120749928542L;

	public TeamDoesNotExistException(@NonNull final String errorMessage) {
		super(errorMessage);
	}

}
