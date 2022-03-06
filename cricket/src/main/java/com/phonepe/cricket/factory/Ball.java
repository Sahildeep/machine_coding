package com.phonepe.cricket.factory;

import com.phonepe.cricket.enums.BallType;
import com.phonepe.cricket.model.match.Commentary;
import com.phonepe.cricket.model.match.Run;
import com.phonepe.cricket.model.match.Wicket;

import lombok.NonNull;

public abstract class Ball {
	private BallType type;
	private Wicket wicket;
	private Run run;
	private Commentary commentary;

	public Ball(@NonNull final BallType type) {
		this.type = type;
	}

	public BallType getType() {
		return type;
	}

	public void setType(BallType type) {
		this.type = type;
	}

	public Wicket getWicket() {
		return wicket;
	}

	public void setWicket(Wicket wicket) {
		this.wicket = wicket;
	}

	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
		this.run = run;
	}

	public Commentary getCommentary() {
		return commentary;
	}

	public void setCommentary(Commentary commentary) {
		this.commentary = commentary;
	}

}
