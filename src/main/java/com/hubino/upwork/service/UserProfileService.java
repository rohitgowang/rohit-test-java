package com.hubino.upwork.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubino.upwork.entity.ApplicationUser;
import com.hubino.upwork.entity.UserProfile;
import com.hubino.upwork.repository.ProfileRepository;

@Service
public class UserProfileService {

	private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

	@Autowired
	ProfileRepository profileRepository;

	public void save(UserProfile profile) {
		profileRepository.save(profile);
		logger.info("Saved Profile Successfully with id:- " + profile.getId());
	}

	public UserProfile findByUser(ApplicationUser user) {
		return profileRepository.findByUser(user);
	}

	public void updateProfile(UserProfile profile) {
		profileRepository.save(profile);
		logger.info("Updated Profile Succefully");
	}
}
