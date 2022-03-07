package com.phonepe.cricket.model.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.phonepe.cricket.factory.Ball;

import lombok.NonNull;

public class Over {

	private int number;
	private List<Ball> balls;
	private int illegalDeliveries;

	public Over(int number) {
		this.number = number;
		this.balls = new ArrayList<>();
		this.illegalDeliveries = 0;
	}

	public void addBall(@NonNull final Ball ball) {
		balls.add(ball);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Ball> getBalls() {
		return balls;
	}

	public void setBalls(List<Ball> balls) {
		this.balls = balls;
	}

	public int getIllegalDeliveries() {
		return illegalDeliveries;
	}

	public void incrementIllegalDeliveries() {
		this.illegalDeliveries++;
	}

	public boolean isFinished() {
		return balls.size() - illegalDeliveries == 6;
	}

	public int getDotBalls() {
		int dotBalls = 0;
		for (final Ball ball : this.getBalls()) {
			if (Objects.nonNull(ball.getRun()) && ball.getRun().getNumberOfRuns() == 0) {
				dotBalls++;
			}
		}
		return dotBalls;
	}

	public int getWickets() {
		int wickets = 0;
		for (final Ball ball : this.getBalls()) {
			if (Objects.nonNull(ball.getWicket())) {
				wickets++;
			}
		}
		return wickets;
	}

	public int getRunsConceded() {
		int runs = this.getIllegalDeliveries();
		for (final Ball ball : this.getBalls()) {
			if (Objects.nonNull(ball.getRun())) {
				runs += ball.getRun().getNumberOfRuns();
			}
		}
		return runs;
	}

}
