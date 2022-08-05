package com.springboot.exam.portal.service.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exam.portal.helper.UserFoundException;
import com.springboot.exam.portal.model.User;
import com.springboot.exam.portal.model.UserRole;
import com.springboot.exam.portal.repository.RoleRepository;
import com.springboot.exam.portal.repository.UserRepository;
import com.springboot.exam.portal.service.UserService;
@Service
public class UserServiceAdapter implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		User checkUser = (User) this.userRepository.findByUserName(user.getUserName());
		if(checkUser!=null) {
			throw new UserFoundException("User Already Exists In DB");
		}
		else {
			// user create
			
			for(UserRole userRole : userRoles) {
				this.roleRepository.save(userRole.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			checkUser = this.userRepository.save(user);
		}
		return checkUser;
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUserName(userName);
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
	}

	@Override
	public void updateUser(User user) {
		
		this.userRepository.save(user);
		
	}

}
