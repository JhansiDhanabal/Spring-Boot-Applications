package com.example.application.EmployeeUI.service;

import java.util.List;

import com.example.application.EmployeeUI.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}