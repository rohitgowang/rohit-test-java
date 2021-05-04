package com.hubino.upwork.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hubino.upwork.entity.ApplicationUser;

public interface UserRepository extends MongoRepository<ApplicationUser, String>{
	
	public ApplicationUser findByEmail(String email);
	public ApplicationUser findByMobile(long mobile);
}
