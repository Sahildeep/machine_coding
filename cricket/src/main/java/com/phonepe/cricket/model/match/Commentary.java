package com.phonepe.cricket.model.match;

import java.util.Date;

import com.phonepe.cricket.model.user.Commentator;

public class Commentary {

	private String text;
	private Date createdAt;
	private Commentator createdBy;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Commentator getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Commentator createdBy) {
		this.createdBy = createdBy;
	}

}
