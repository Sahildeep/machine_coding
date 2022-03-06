package com.phonepe.cricket.handler;

import com.phonepe.cricket.exceptions.MatchDoesNotExistException;

import lombok.NonNull;

public interface ScoreCardHandler {

	String getScoreCard(@NonNull final String matchId) throws MatchDoesNotExistException;

	String getMatchResult(@NonNull final String id) throws MatchDoesNotExistException;

}
