package com.springboot.exam.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.exam.portal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserName(String userName);
}
