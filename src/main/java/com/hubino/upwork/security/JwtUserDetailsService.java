package com.hubino.upwork.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;

import com.hubino.upwork.dao.UserRepository;
import com.hubino.upwork.entity.ApplicationUser;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser applicationUser = userRepository.findByEmail(username);
        if (applicationUser == null) {
        	applicationUser = userRepository.findByMobile(Long.parseLong(username));
        }else if(applicationUser == null)
            throw new UsernameNotFoundException(username);
        return new User(applicationUser.getEmail(), applicationUser.getPassword(), emptyList());
	}
}
