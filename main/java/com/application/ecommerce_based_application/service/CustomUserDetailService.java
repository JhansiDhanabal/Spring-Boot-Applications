package com.application.ecommerce_based_application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.application.ecommerce_based_application.repository.UserRepository;
import com.application.ecommerce_based_application.model.CustomUserDetail;
import com.application.ecommerce_based_application.model.User;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findUserByEmail(username);
		user.orElseThrow(()->new UsernameNotFoundException("User not found"));
		return user.map(CustomUserDetail::new ).get();
		
	}

}
