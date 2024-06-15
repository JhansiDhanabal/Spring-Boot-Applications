package com.application.ecommerce_based_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.ecommerce_based_application.model.*;
import com.application.ecommerce_based_application.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	public Optional<Product> getProductById(long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}
	
	public List<Product> getAllProductByCategoryId(int id){
		return productRepository.findByCategoryId(id);
	}
}
