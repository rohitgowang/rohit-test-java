package com.hubino.upwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubino.upwork.dao.ProfileRepository;
import com.hubino.upwork.entity.ApplicationUser;
import com.hubino.upwork.entity.UserProfile;

@Service
public class UserProfileService {

	@Autowired
	ProfileRepository profileRepository;

	public void save(UserProfile profile) {
		profileRepository.save(profile);
	}

	public UserProfile findByUser(ApplicationUser user) {
		return profileRepository.findByUser(user);
	}

	public void updateProfile(UserProfile profile) {
		profileRepository.save(profile);
	}
}
