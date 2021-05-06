package com.hubino.upwork.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter {
	@Value("${jwt.secret}")
	private String KEY = "tjhlw9z$C&F)J@NcQfTjWnZr4u7x!A%D*G-KaPdSgUkXp2jlhg/B?E(H+Mbkgic";

	public AuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader("Authorization");

		if (header == null) {
			chain.doFilter(request, response);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = authenticate(request);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request) {
		System.out.println("KEY VALUE:- " + KEY);
		String token = request.getHeader("Authorization");
		if (token != null) {
			Claims user = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();

			if (user != null) {
				request.setAttribute("emailId", user.getSubject());
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
			} else {
				return null;
			}

		}
		return null;
	}
}
