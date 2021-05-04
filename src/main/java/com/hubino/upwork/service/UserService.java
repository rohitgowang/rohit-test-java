package com.hubino.upwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubino.upwork.dao.UserRepository;
import com.hubino.upwork.entity.ApplicationUser;
@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public String test() {
		repository.deleteAll();
		repository.save(new ApplicationUser(9234567890l,"rohit@gmail.com", "rohit@123"));
		repository.save(new ApplicationUser(9234567890l, "amit@gmail.com", "amit@123"));
		
		for(ApplicationUser user : repository.findAll()) {
			System.out.println(user);
		}
		System.out.println("Customers find with findByFirstName:--------");
		System.out.println(repository.findByEmail("amit@gmail.com"));
		return "done";
	}
	
	public void save(ApplicationUser user ) {
		repository.save(user);
	}
}
