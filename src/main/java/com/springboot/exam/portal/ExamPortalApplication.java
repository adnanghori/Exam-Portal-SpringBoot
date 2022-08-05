package com.springboot.exam.portal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.exam.portal.model.Role;
import com.springboot.exam.portal.model.User;
import com.springboot.exam.portal.model.UserRole;
import com.springboot.exam.portal.service.UserService;

@SpringBootApplication
public class ExamPortalApplication /* implements CommandLineRunner*/ {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	//@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName("adnan_ghori");
		user.setUserFirstName("adnan");
		user.setUserLastName("ghori");
		user.setRawPassword("123");
		user.setUserPassword(this.bCryptPasswordEncoder.encode(user.getRawPassword()));
		user.setUserEmail("a@b.com");
		user.setUserProfile("profile.png");
		
		Role role = new Role();
		role.setRoleName("ADMIN");
		
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);	
		
		User saveUser = this.userService.createUser(user, userRoles);
		
		 
	}

}
