package com.springboot.exam.portal.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.springboot.exam.portal.model.User;
import com.springboot.exam.portal.model.UserRole;
@Service
public interface UserService {
	
		// creating user
	
		public User createUser(User user , Set<UserRole> userRoles) throws Exception;
		public User getUser(String userName);
		public void deleteUser(Long userId);
		public void updateUser(User user);
}
 