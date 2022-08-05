package com.springboot.exam.portal.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springboot.exam.portal.model.User;
import com.springboot.exam.portal.repository.UserRepository;
@Component
public class UserDetailsServiceAdapter implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepository.findByUserName(username);
		if(user==null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("No User Found");
		}
		return user;
	}
	
}
