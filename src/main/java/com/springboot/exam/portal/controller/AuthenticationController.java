package com.springboot.exam.portal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exam.portal.configuration.JwtUtil;
import com.springboot.exam.portal.model.JwtRequest;
import com.springboot.exam.portal.model.JwtResponse;
import com.springboot.exam.portal.model.User;
import com.springboot.exam.portal.service.implementation.UserDetailsServiceAdapter;
import com.springboot.exam.portal.service.implementation.UserServiceAdapter;
@CrossOrigin
@RestController
public class AuthenticationController {
		@Autowired
		private AuthenticationManager authenticationManager;
		@Autowired
		private UserDetailsServiceAdapter userDetailsServiceAdapter;
		@Autowired
		private JwtUtil jwtUtil;
		@Autowired
		private UserServiceAdapter userServiceAdapter;
		
		
		 private void authenticate(String username , String password) {
			 try {
				 this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			 }catch (DisabledException de) {
				// TODO: handle exception
				 throw new DisabledException("User Disabled"+de.getMessage());
			}      
			 catch (BadCredentialsException bce) {
				// TODO: handle exception
				 throw new BadCredentialsException("Invalid Credentials"+bce.getMessage());
				 
			}
		 }
		 @PostMapping("/generate-token")
		 public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest){
			 try {
				 authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			} catch (UsernameNotFoundException e) {
				// TODO: handle exception
				throw new UsernameNotFoundException("User Not Found");
			}
			 UserDetails userDetails = this.userDetailsServiceAdapter.loadUserByUsername(jwtRequest.getUsername());		 
			 String token = this.jwtUtil.generateToken(userDetails); 
			 return ResponseEntity.ok(new JwtResponse(token));
		 }
		 @GetMapping("/current-user")
		 public User getCurrentUser(Principal principal) {
			 
			 return this.userServiceAdapter.getUser(principal.getName());
			
		 }
}
