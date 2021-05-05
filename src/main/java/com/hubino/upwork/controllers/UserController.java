package com.hubino.upwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hubino.upwork.entity.ApplicationUser;
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

	@PostMapping("/signUp")
	public void signUp(@RequestBody UserProfile userProfile) {
		userProfile.getUser().setPassword(bCryptPasswordEncoder.encode(userProfile.getUser().getPassword()));
		userService.save(userProfile.getUser());
		userProfileService.save(userProfile);
	}

	@RequestMapping("/userProfile")
	public @ResponseBody UserProfile getUserProfile(@RequestBody ApplicationUser user) {
		UserProfile profile = userProfileService.findByUser(user);
		profile.getUser().setPassword(bCryptPasswordEncoder.encode(profile.getUser().getPassword()));
		return profile;
	}

	@RequestMapping("/updateProfile")
	public String updateProfile(@RequestBody UserProfile userProfile) {
		userProfileService.updateProfile(userProfile);
		return "Profile Updated Successfully";
	}

}
