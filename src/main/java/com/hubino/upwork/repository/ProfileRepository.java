package com.hubino.upwork.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hubino.upwork.entity.ApplicationUser;
import com.hubino.upwork.entity.UserProfile;

public interface ProfileRepository extends MongoRepository<UserProfile, String> {

	public UserProfile findByEmailId(String email);

	public UserProfile findByUser(ApplicationUser user);

}
