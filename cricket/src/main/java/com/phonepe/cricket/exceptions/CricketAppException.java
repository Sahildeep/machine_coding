package com.phonepe.cricket.exceptions;

import lombok.NonNull;

public class CricketAppException extends Exception {

	private static final long serialVersionUID = 72751372833326879L;

	public CricketAppException(@NonNull final String errorMessage) {
		super(errorMessage);
	}
	
}
