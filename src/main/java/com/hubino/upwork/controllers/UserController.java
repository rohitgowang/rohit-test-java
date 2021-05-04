package com.hubino.upwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubino.upwork.entity.ApplicationUser;
import com.hubino.upwork.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping("/test")
	public String test() {
		userService.test();
		return "test done";
	}
	
	

    @PostMapping("/signUp")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
    }
    
    @RequestMapping("userProfile")
    public void getUserProfile() {
    
    }
}
