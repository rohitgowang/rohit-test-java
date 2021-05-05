package com.hubino.upwork.entity;

import org.springframework.data.annotation.Id;

public class ApplicationUser {

	@Id
	public String id;
	public String emailId;
	public long mobile;
	public String password;

	public ApplicationUser() {
		super();
	}

	public ApplicationUser(String emailId, long mobile, String password) {
		super();
		this.emailId = emailId;
		this.mobile = mobile;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ApplicationUser [id=" + id + ", emailId=" + emailId + ", mobile=" + mobile + ", password=" + password
				+ "]";
	}

}
