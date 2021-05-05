package com.hubino.upwork.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hubino.upwork.entity.ApplicationUser;

public interface UserRepository extends MongoRepository<ApplicationUser, String> {

	public ApplicationUser findByEmailId(String emailId);

	public ApplicationUser findByMobile(long mobile);

	public Optional<ApplicationUser> findById(String Id);
}
