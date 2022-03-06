package com.phonepe.cricket.model.match;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.NonNull;

public class Inning {

	private final int number;
	private final Date startTime;
	private final List<Over> overs;
	private final Team team;

	public Inning(@NonNull final int number, @NonNull final Team team, @NonNull final int overs) {
		this.number = number;
		this.startTime = new Date();
		this.overs = new ArrayList<>();
		this.team = team;
	}

	public Over getCurrentOver() {
		return overs.get(overs.size() - 1);
	}

	public void addOver(@NonNull final Over over) {
		overs.add(over);
	}

	public int getNumber() {
		return number;
	}

	public Date getStartTime() {
		return startTime;
	}

	public List<Over> getOvers() {
		return overs;
	}

	public Team getTeam() {
		return team;
	}

}
