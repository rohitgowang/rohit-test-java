package com.hubino.upwork.entity;

import org.springframework.data.annotation.Id;

public class ApplicationUser {

	@Id
	public String id;
	public String username;
	public String password;

	public ApplicationUser() {
	}

	public ApplicationUser(String email, String password) {
		this.username = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
