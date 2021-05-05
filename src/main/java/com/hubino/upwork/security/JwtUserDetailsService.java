package com.hubino.upwork.security;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hubino.upwork.dao.UserRepository;
import com.hubino.upwork.entity.ApplicationUser;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("username:- " + username);
		ApplicationUser applicationUser = userRepository.findByUsername(username);
		System.out.println("user----" + applicationUser);
		if (applicationUser == null)
			throw new UsernameNotFoundException(username);
		return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
	}
}
