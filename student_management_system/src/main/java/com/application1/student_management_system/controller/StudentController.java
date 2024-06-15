package com.application1.student_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.application1.student_management_system.entity.Student;
import com.application1.student_management_system.service.StudentService;

@Controller
public class StudentController {
	StudentService service;
	
    public StudentController(StudentService service) {
		super();
		this.service = service;
	}
    
	@GetMapping({"/students","/"})
    public String home(Model model) {
		model.addAttribute("students", service.ShowListStudent());
        return "home"; 
    }
	@GetMapping("/addStudents")
	public String add(Model model) {
		Student st = new Student();
		model.addAttribute("student", st);
		return "entry-form";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute("student") Student st) {
		service.saveStudent(st);
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable int id, Model model) {
		Student st = service.getStudentById(id);
		service.deleteStudent(st);
		return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String updatestudent(@PathVariable int id, Model model) {
		Student st = service.getStudentById(id);
		model.addAttribute("student", st);
		return "update-form";
	}
	
	@PostMapping("/students/edit/{id}")
	public String edit(@PathVariable int id, @ModelAttribute("student") Student st) {
		Student st1 = service.getStudentById(id);
		st1.setFirstName(st.getFirstName());
		st1.setEmail(st.getEmail());
		st1.setLastName(st.getLastName());
		service.updateStudent(st1);
		return "redirect:/students";
	}
}
