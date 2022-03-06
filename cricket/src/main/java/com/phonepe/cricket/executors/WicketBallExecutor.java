package com.phonepe.cricket.executors;

import com.phonepe.cricket.enums.BallType;
import com.phonepe.cricket.factory.Ball;
import com.phonepe.cricket.model.match.Inning;
import com.phonepe.cricket.model.match.Match;
import com.phonepe.cricket.model.match.Over;
import com.phonepe.cricket.model.match.Team;
import com.phonepe.cricket.model.user.Player;

import lombok.NonNull;

public class WicketBallExecutor extends BallExecutor {

	public WicketBallExecutor() {
		super(BallType.WICKET);
	}

	@Override
	public void execute(@NonNull final Match match, @NonNull final Ball ball) {
		final Inning inning = match.getCurrentInning();
		final Team team = inning.getTeam();
		final Player player = team.getCurrentPlayer();
		final Over over = inning.getCurrentOver();
		over.addBall(ball);
		player.incrementBallsPlayed();
		player.setOut();
		team.fallOfWicket();
		if (over.isFinished()) {
			team.changeStrike();
		}
	}

}
