package com.phonepe.cricket.model.match;

import java.util.ArrayList;
import java.util.List;

import com.phonepe.cricket.model.user.Coach;
import com.phonepe.cricket.model.user.Player;

import lombok.NonNull;

public class Team {

	private int size;
	private String name;
	private List<Player> players;
	private int strikerIdx;
	private int nonStrikerIdx;
	private Coach coach;
	private int outs;
	private int extras;
	private int scores;

	public Team(@NonNull final String teamName, @NonNull final int size) {
		this.name = teamName;
		this.size = size;
		this.players = new ArrayList<>();
		this.strikerIdx = 0;
		this.nonStrikerIdx = 1;
		this.outs = 0;
		this.extras = 0;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public int getOuts() {
		return outs;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player getCurrentPlayer() {
		return players.get(strikerIdx);
	}

	public void changeStrike() {
		int playerIdx = strikerIdx;
		strikerIdx = nonStrikerIdx;
		nonStrikerIdx = playerIdx;
	}

	public void fallOfWicket() {
		outs++;
		strikerIdx = Math.max(strikerIdx, nonStrikerIdx) + 1;
	}

	public void addExtras(int extra) {
		this.extras += extra;
	}

	public int getExtras() {
		return extras;
	}

	public boolean isAllOut() {
		return outs == size - 1;
	}

	public int getStrikerIdx() {
		return strikerIdx;
	}

	public int getNonStrikerIdx() {
		return nonStrikerIdx;
	}

	public void addScores(int score) {
		this.scores += score;
	}

	public int getScores() {
		return scores;
	}

}
