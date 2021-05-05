package com.hubino.upwork.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hubino.upwork.entity.ApplicationUser;

public interface UserRepository extends MongoRepository<ApplicationUser, String> {

	public ApplicationUser findByUsername(String username);

	public Optional<ApplicationUser> findById(String Id);
}
