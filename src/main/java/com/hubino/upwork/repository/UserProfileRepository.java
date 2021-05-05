package com.hubino.upwork.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hubino.upwork.entity.ApplicationUser;
import com.hubino.upwork.entity.UserProfile;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
	public UserProfile findByUser(ApplicationUser user);
}
