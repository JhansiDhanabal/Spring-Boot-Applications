package com.example.application.EmployeeUI.contoller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.application.EmployeeUI.entity.Employee;
import com.example.application.EmployeeUI.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	
	public EmployeeController(EmployeeService emp) {
		employeeService = emp;
	}
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
		//get the employees from db
		List<Employee> emp = employeeService.findAll();
		//add to the spring model
		model.addAttribute("employees", emp);
		return "employees/list-employee";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		//create model attribute to bind form data
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		//save the employee
		employeeService.save(emp);
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("employeeId")int id, Model model) {
		//get the employee from the service
		Employee emp = employeeService.findById(id);
		//set employee in the model to prepopulate the form
		model.addAttribute("employee", emp);
		//send over to our form
		return "employees/employee-form";
	}
	@GetMapping("/showFormDelete")
	public String showFormDelete(@RequestParam("employeeId")int id, Model model) {
		//delete the employee from the service
		employeeService.deleteById(id);
		//send over to our form
		return "redirect:/employees/list";
	}
}
