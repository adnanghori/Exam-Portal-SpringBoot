package com.springboot.exam.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.exam.portal.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
