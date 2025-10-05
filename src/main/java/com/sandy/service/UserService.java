package com.sandy.service;

import org.springframework.security.config.web.server.ServerSecurityMarker;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sandy.entity.User;
import com.sandy.repositary.UserRepository;

@Component
public class UserService {

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
	}
	
	public void registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
		
}
