package com.springboot.exam.portal.service;

import java.util.Set;

import com.springboot.exam.portal.model.exam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(Long cid);
	public void deleteCategory(Long cid);
}
