package com.phonepe.cricket.model.match;

import com.phonepe.cricket.enums.RunType;

public class Run {

	private int numberOfRuns;
	private RunType runtype;

	public Run(int numberOfRuns, RunType runtype) {
		this.numberOfRuns = numberOfRuns;
		this.runtype = runtype;
	}

	public int getNumberOfRuns() {
		return numberOfRuns;
	}

	public void setNumberOfRuns(int numberOfRuns) {
		this.numberOfRuns = numberOfRuns;
	}

	public RunType getRuntype() {
		return runtype;
	}

	public void setRuntype(RunType runtype) {
		this.runtype = runtype;
	}

}
