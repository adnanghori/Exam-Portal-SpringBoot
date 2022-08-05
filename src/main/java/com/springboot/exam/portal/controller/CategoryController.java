package com.springboot.exam.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exam.portal.model.exam.Category;
import com.springboot.exam.portal.service.implementation.CategoryServiceAdapter;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	@Autowired
	private CategoryServiceAdapter categoryServiceAdapter;
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		
		category = this.categoryServiceAdapter.addCategory(category);
		return ResponseEntity.ok(category);
	}
	
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId)
	{
		return this.categoryServiceAdapter.getCategory(categoryId);
	}
	@GetMapping("/")
	public ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(this.categoryServiceAdapter.getCategories());
	}
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.categoryServiceAdapter.updateCategory(category);
	}
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId){
		this.categoryServiceAdapter.deleteCategory(categoryId);
		//return ResponseEntity.ok("Deleted");
	}
}
