package com.phonepe.cricket.exceptions;

import lombok.NonNull;

public class TeamAlreadyExistsException extends CricketAppException {

	private static final long serialVersionUID = -5546538760137719241L;

	public TeamAlreadyExistsException(@NonNull final String errorMessage) {
		super(errorMessage);
	}
	
}
