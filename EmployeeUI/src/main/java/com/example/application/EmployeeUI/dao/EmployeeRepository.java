package com.example.application.EmployeeUI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.EmployeeUI.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
	// add a method to sort by lastname
	public List<Employee> findAllByOrderByLastNameAsc(); //this method automatically sort and return no need to implement
}
