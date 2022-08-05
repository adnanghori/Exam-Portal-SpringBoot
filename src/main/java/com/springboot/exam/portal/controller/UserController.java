package com.springboot.exam.portal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exam.portal.helper.UserFoundException;
import com.springboot.exam.portal.helper.UserNotFoundException;
import com.springboot.exam.portal.model.Role;
import com.springboot.exam.portal.model.User;
import com.springboot.exam.portal.model.UserRole;
import com.springboot.exam.portal.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
		@Autowired
		private UserService userService;
		@Autowired
		private BCryptPasswordEncoder bCryptPasswordEncoder;
		// creating user
	
		@PostMapping("/")
	 	public User createUser(@RequestBody User user) throws Exception {
			user.setRawPassword(user.getUserPassword());
			user.setUserProfile("default.png");
			user.setUserPassword(this.bCryptPasswordEncoder.encode(user.getUserPassword()));
			Set<UserRole> userRoles = new HashSet<>();
			Role role = new Role();
			role.setRoleName("NORMAL");
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRoles.add(userRole);
	 		return this.userService.createUser(user, userRoles);
	 	}
		
		@GetMapping("/{userName}")
		public User getUser(@PathVariable("userName") String userName) {
			
			return this.userService.getUser(userName);
			
		}
		@PutMapping("/")
		public void updateUser(@RequestBody User user) {
			this.userService.updateUser(user);
			
		}
		@DeleteMapping("/{deleteId}")
		public void deleteUser(@PathVariable("deleteId") Long deleteId) {
			this.userService.deleteUser(deleteId);
		}
		
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<?> exceptionHandler(UserNotFoundException unfe){
			return ResponseEntity.notFound().build();
		}
		@ExceptionHandler(UserFoundException.class)
		public ResponseEntity<?> exceptionHandler(UserFoundException ufe){
			return ResponseEntity.ok("User Found");
		}
		
		
} 
