package com.hubino.upwork.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubino.upwork.entity.UserProfile;
import com.hubino.upwork.repository.ProfileRepository;

@Service
public class UserProfileService {

	private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

	@Autowired
	ProfileRepository profileRepository;

	public UserProfile save(UserProfile profile) {
		UserProfile savedProfile = profileRepository.save(profile);
		return savedProfile;
	}

	public UserProfile findByEmailId(String email) {
		return profileRepository.findByEmailId(email);
	}

// updating the profile while checking if the profile exists or not if not then return null.
	public UserProfile updateProfile(UserProfile profile) {
		UserProfile profile1 = profileRepository.findByUser(profile.getUser());
		if (profile1 != null) {
			UserProfile savedProfile = profileRepository.save(profile);
			return savedProfile;
		}
		return null;
	}
}
