package com.hubino.upwork.entity;

import org.springframework.data.annotation.Id;

public class ApplicationUser {

	@Id
	public String id;
	public String email;
	public String password;
	public long mobile;
	
	public ApplicationUser(long mobile,String email, String password) {
		super();
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
