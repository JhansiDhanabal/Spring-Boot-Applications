package com.application.ecommerce_based_application.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.application.ecommerce_based_application.model.Role;

public interface RoleRepository  extends JpaRepository<Role, Integer> {
	
}
