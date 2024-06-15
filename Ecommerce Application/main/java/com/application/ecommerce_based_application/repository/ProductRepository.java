package com.application.ecommerce_based_application.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.ecommerce_based_application.model.*;
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByCategoryId(int categoryId);

}
