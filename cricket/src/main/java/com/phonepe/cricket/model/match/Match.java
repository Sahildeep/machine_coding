package com.phonepe.cricket.model.match;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.phonepe.cricket.enums.MatchResult;
import com.phonepe.cricket.model.user.Commentator;
import com.phonepe.cricket.model.user.Umpire;

import lombok.NonNull;

public class Match {

	private final String id;
	private final Date startTime;
	private MatchResult result;
	private final List<Inning> innings;
	private final List<Umpire> umpires;
	private final List<Commentator> commentators;
	private int currentInningIdx;

	public Match(@NonNull final String matchId, @NonNull final List<Team> teams, @NonNull final int overs) {
		this.id = matchId;
		this.startTime = new Date();
		this.result = MatchResult.LIVE;
		this.innings = createInnings(teams, overs);
		this.umpires = new ArrayList<>();
		this.commentators = new ArrayList<>();
		this.currentInningIdx = 0;
	}

	private List<Inning> createInnings(@NonNull final List<Team> teams, @NonNull final int overs) {
		final List<Inning> innings = new ArrayList<>();
		innings.add(new Inning(1, teams.get(0), overs));
		innings.add(new Inning(2, teams.get(1), overs));
		return innings;
	}

	public String getId() {
		return id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public MatchResult getResult() {
		return result;
	}

	public List<Inning> getInnings() {
		return innings;
	}

	public List<Umpire> getUmpires() {
		return umpires;
	}

	public List<Commentator> getCommentators() {
		return commentators;
	}

	public void incrementCurrentInningIdx() {
		this.currentInningIdx++;
	}

	public void finishedMatch() {
		this.result = MatchResult.FINISHED;
	}

	public void drawnMatch() {
		this.result = MatchResult.DRAWN;
	}

	public void cancelledMatch() {
		this.result = MatchResult.CANCELED;
	}

	public Inning getCurrentInning() {
		return this.innings.get(this.currentInningIdx);
	}

}
