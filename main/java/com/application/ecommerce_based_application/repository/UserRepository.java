package com.application.ecommerce_based_application.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.ecommerce_based_application.model.*;
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User>findUserByEmail(String email);
	Optional<User> findByEmail(String email);
}
