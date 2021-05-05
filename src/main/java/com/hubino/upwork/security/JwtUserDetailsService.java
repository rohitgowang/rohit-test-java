package com.hubino.upwork.security;

import static java.util.Collections.emptyList;

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("username:- " + username);
		ApplicationUser applicationUser = userRepository.findByEmailId(username);

		System.out.println("user----" + applicationUser);
		if (applicationUser == null) {
			applicationUser = userRepository.findByMobile(Long.valueOf(username));
			if (applicationUser == null)
				throw new UsernameNotFoundException(username);
		}
		return new User(applicationUser.getEmailId(), applicationUser.getPassword(), emptyList());
	}
}
