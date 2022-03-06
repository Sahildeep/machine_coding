package com.phonepe.cricket.executors;

import com.phonepe.cricket.enums.BallType;
import com.phonepe.cricket.factory.Ball;
import com.phonepe.cricket.model.match.Inning;
import com.phonepe.cricket.model.match.Match;
import com.phonepe.cricket.model.match.Over;
import com.phonepe.cricket.model.match.Team;

import lombok.NonNull;

public class NoBallExecutor extends BallExecutor {

	public NoBallExecutor() {
		super(BallType.NO_BALL);
	}

	@Override
	public void execute(@NonNull final Match match, @NonNull final Ball ball) {
		final Inning inning = match.getCurrentInning();
		final Team team = inning.getTeam();
		final Over over = inning.getCurrentOver();
		over.addBall(ball);
		team.addExtras(1);
		over.incrementIllegalDeliveries();
	}

}
