package com.lnganalysis.entities.domain;

import java.util.Date;

public class UserAudit {
	private int id;
	private Date createdDate;
	private String comments;
	private String actionFlag;
	private String action;
	private String createdBy;
//	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getActionFlag() {
		return actionFlag;
	}
	public void setActionFlag(String actionFlag) {
		this.actionFlag = actionFlag;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
	
}
