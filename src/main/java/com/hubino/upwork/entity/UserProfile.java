package com.hubino.upwork.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

public class UserProfile {
	
	@Id
	public String id;
	public ApplicationUser user;
	public String firstName;
	public String lastName;
	public List<History> historyList; 
	
}
