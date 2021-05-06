package com.hubino.upwork.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubino.upwork.entity.UserProfile;
import com.hubino.upwork.service.UserProfileService;
import com.hubino.upwork.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UserProfileService userProfileService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@PostMapping("/signUp")
	public ResponseEntity<Object> signUp(@RequestBody UserProfile userProfile) {

		logger.info("#########Request to add a new UserProfile with details:- " + userProfile.toString());

		userProfile.getUser().setPassword(bCryptPasswordEncoder.encode(userProfile.getUser().getPassword()));

		userService.save(userProfile.getUser());

		UserProfile savedProfile = userProfileService.save(userProfile);
		if (savedProfile != null) {
			logger.info("Saved Profile Successfully with id:- " + savedProfile.getId());
			return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
		}
		logger.error("Unable to save the profile while signup");
		return new ResponseEntity<>("Unable to save profile. please check the request", HttpStatus.BAD_REQUEST);

	}

	@RequestMapping("/userProfile")
	public ResponseEntity<Object> getUserProfile(@RequestBody String email) {

		logger.info("#########Request to fetch userProfile for the User with emailId:- " + email);

		UserProfile profile = userProfileService.findByEmailId(email);
		if (profile != null) {
			profile.getUser().setPassword(bCryptPasswordEncoder.encode(profile.getUser().getPassword()));

			return new ResponseEntity<>(profile, HttpStatus.FOUND);
		}
		logger.error("No profile found with the email id:- " + email);
		return new ResponseEntity<>("UserProfile not found", HttpStatus.NOT_FOUND);
	}

	@RequestMapping("/updateProfile")
	public ResponseEntity<Object> updateProfile(@RequestBody UserProfile userProfile) {
		logger.info("#########Request to update the profile with the updated data" + userProfile.toString());

		UserProfile savedProfile = userProfileService.updateProfile(userProfile);
		if (savedProfile != null) {
			return new ResponseEntity<>(savedProfile, HttpStatus.ACCEPTED);
		}
		logger.error("Unable to update profile");
		return new ResponseEntity<>(savedProfile, HttpStatus.BAD_REQUEST);
	}

}
