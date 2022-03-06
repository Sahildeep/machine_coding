package com.phonepe.cricket.model.match;

import com.phonepe.cricket.enums.WicketType;
import com.phonepe.cricket.model.user.Player;

public class Wicket {

	private WicketType wicketType;
	private Player playerOut;
	private Player caughtBy;
	private Player runoutBy;
	private Player stumpedBy;

	public WicketType getWicketType() {
		return wicketType;
	}

	public void setWicketType(WicketType wicketType) {
		this.wicketType = wicketType;
	}

	public Player getPlayerOut() {
		return playerOut;
	}

	public void setPlayerOut(Player playerOut) {
		this.playerOut = playerOut;
	}

	public Player getCaughtBy() {
		return caughtBy;
	}

	public void setCaughtBy(Player caughtBy) {
		this.caughtBy = caughtBy;
	}

	public Player getRunoutBy() {
		return runoutBy;
	}

	public void setRunoutBy(Player runoutBy) {
		this.runoutBy = runoutBy;
	}

	public Player getStumpedBy() {
		return stumpedBy;
	}

	public void setStumpedBy(Player stumpedBy) {
		this.stumpedBy = stumpedBy;
	}

}
