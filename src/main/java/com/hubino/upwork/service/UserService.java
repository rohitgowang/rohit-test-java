package com.hubino.upwork.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubino.upwork.entity.ApplicationUser;
import com.hubino.upwork.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	public void save(ApplicationUser user) {
		logger.info("Saving new User while SignUp with emailId:- " + user.getEmailId());
		repository.save(user);
		logger.info("User saved successfully with id:- " + user.getId());
	}
}
