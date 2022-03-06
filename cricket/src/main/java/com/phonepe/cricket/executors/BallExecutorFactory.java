package com.phonepe.cricket.executors;

import java.util.HashMap;
import java.util.Map;

import com.phonepe.cricket.enums.BallType;
import com.phonepe.cricket.factory.Ball;
import com.phonepe.cricket.model.match.Match;

import lombok.NonNull;

public class BallExecutorFactory {

	private static final Map<BallType, BallExecutor> BALL_EXECUTOR_MAP;

	static {
		BALL_EXECUTOR_MAP = new HashMap<>();
		BALL_EXECUTOR_MAP.put(BallType.NORMAL, new NormalBallExecutor());
		BALL_EXECUTOR_MAP.put(BallType.WIDE, new WideBallExecutor());
		BALL_EXECUTOR_MAP.put(BallType.WICKET, new WicketBallExecutor());
		BALL_EXECUTOR_MAP.put(BallType.NO_BALL, new NoBallExecutor());
	}

	public void executeBall(@NonNull final Match match, @NonNull final Ball ball) {
		BALL_EXECUTOR_MAP.get(ball.getType()).execute(match, ball);
	}

}
