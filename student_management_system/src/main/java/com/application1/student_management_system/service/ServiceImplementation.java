package com.application1.student_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application1.student_management_system.entity.Student;
import com.application1.student_management_system.repository.StudentRepository;

@Service
public class ServiceImplementation implements StudentService {
	StudentRepository repository;
	
	@Autowired
	public ServiceImplementation(StudentRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public List<Student> ShowListStudent() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void saveStudent(Student st) {
		// TODO Auto-generated method stub
		repository.save(st);
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	@Override
	public void deleteStudent(Student st) {
		// TODO Auto-generated method stub
		repository.delete(st);
	}

	@Override
	public void updateStudent(Student sd) {
		// TODO Auto-generated method stub
		repository.save(sd);
	}

	

	
}
