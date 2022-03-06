package com.phonepe.cricket.model.user;

import lombok.NonNull;

public class Player extends Person {

	private int score;
	private int fours;
	private int sixes;
	private int ballsPlayed;
	private boolean isOut;

	public Player(@NonNull final String id) {
		this.setId(id);
		this.score = 0;
		this.fours = 0;
		this.sixes = 0;
		this.ballsPlayed = 0;
		this.isOut = false;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public int getFours() {
		return fours;
	}

	public void incrementFours() {
		this.fours++;
	}

	public int getSixes() {
		return sixes;
	}

	public void incrementSixes() {
		this.sixes++;
	}

	public int getBallsPlayed() {
		return ballsPlayed;
	}

	public void incrementBallsPlayed() {
		this.ballsPlayed++;
	}

	public void setOut() {
		this.isOut = true;
	}

	public boolean isOut() {
		return this.isOut;
	}

}
