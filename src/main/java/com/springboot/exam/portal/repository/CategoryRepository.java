package com.springboot.exam.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.exam.portal.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
