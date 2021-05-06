package com.hubino.upwork.security;

import static java.util.Collections.emptyList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hubino.upwork.entity.ApplicationUser;
import com.hubino.upwork.repository.ProfileRepository;
import com.hubino.upwork.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProfileRepository profileRepository;

	private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ApplicationUser applicationUser = userRepository.findByEmailId(username);

		if (applicationUser == null) {
			applicationUser = userRepository.findByMobile(Long.valueOf(username));
			if (applicationUser == null) {
				logger.error("No USER found with the credentials entered.");
			} else {
				return new User(Long.toString(applicationUser.getMobile()), applicationUser.getPassword(), emptyList());
			}
		}

		logger.info("User Details are:- " + applicationUser.getEmailId() + " " + applicationUser.getMobile());
		return new User(applicationUser.getEmailId(), applicationUser.getPassword(), emptyList());
	}
}
