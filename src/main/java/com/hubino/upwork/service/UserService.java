package com.hubino.upwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubino.upwork.dao.UserRepository;
import com.hubino.upwork.entity.ApplicationUser;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public void save(ApplicationUser user) {
		repository.save(user);
	}
}
