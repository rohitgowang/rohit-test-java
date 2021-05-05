package com.hubino.upwork.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class UserProfile {

	@Id
	public String id;
	@DBRef
	public ApplicationUser user;
	public String firstName;
	public String lastName;
	public String emailId;
	public long mobile;
	public List<History> historyList;

	public UserProfile() {
	}

	public UserProfile(ApplicationUser user, String firstName, String lastName, String emailId, long mobile,
			List<History> historyList) {
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.historyList = historyList;
		this.emailId = emailId;
		this.mobile = mobile;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ApplicationUser getUser() {
		return user;
	}

	public void setUser(ApplicationUser user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<History> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List<History> historyList) {
		this.historyList = historyList;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", user=" + user + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", historyList=" + historyList + "]";
	}

}
