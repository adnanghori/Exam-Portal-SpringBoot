package com.springboot.exam.portal.service.implementation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exam.portal.model.exam.Category;
import com.springboot.exam.portal.repository.CategoryRepository;
import com.springboot.exam.portal.service.CategoryService;
@Service
public class CategoryServiceAdapter implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<Category>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long cid) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(cid).get();  
	}

	@Override
	public void deleteCategory(Long cid) {
		// TODO Auto-generated method stub
		this.categoryRepository.deleteById(cid);
	}

}
