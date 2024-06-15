package com.application.ecommerce_based_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.ecommerce_based_application.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
