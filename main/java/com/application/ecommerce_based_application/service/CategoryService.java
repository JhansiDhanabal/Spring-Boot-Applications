package com.application.ecommerce_based_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.ecommerce_based_application.repository.CategoryRepository;
import com.application.ecommerce_based_application.model.*;
@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
	}

	public Optional<Category> getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}
}
