package com.phonepe.cricket.executors;

import com.phonepe.cricket.enums.BallType;
import com.phonepe.cricket.factory.Ball;
import com.phonepe.cricket.model.match.Match;

import lombok.NonNull;

public abstract class BallExecutor {

	private final BallType ballType;

	public BallExecutor(@NonNull final BallType ballType) {
		this.ballType = ballType;
	}

	public abstract void execute(@NonNull final Match match, @NonNull final Ball ball);

	public BallType getBallType() {
		return ballType;
	}

}
