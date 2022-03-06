package com.phonepe.cricket.factory;

import com.phonepe.cricket.enums.RunType;
import com.phonepe.cricket.model.match.Run;
import com.phonepe.cricket.model.match.Wicket;

import lombok.NonNull;

public class BallFactory {

	public Ball getBall(@NonNull final String ballStr) {
		Ball ball = null;
		if ("Nb".equals(ballStr)) {
			ball = new NoBall();
		} else if ("Wd".equals(ballStr)) {
			ball = new WideBall();
		} else if ("W".equals(ballStr)) {
			ball = new WicketBall();
			ball.setWicket(new Wicket());
		} else {
			ball = new NormalBall();
			final int run = Integer.parseInt(ballStr);
			ball.setRun(new Run(run, getRunType(run)));
		}
		return ball;
	}

	private RunType getRunType(@NonNull final int run) {
		RunType runType = RunType.NORMAL;
		if (run == 6) {
			runType = RunType.SIX;
		} else if (run == 4) {
			runType = RunType.FOUR;
		}
		return runType;
	}

}
