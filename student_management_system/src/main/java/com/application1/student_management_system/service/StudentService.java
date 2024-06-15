package com.application1.student_management_system.service;

import java.util.List;


import com.application1.student_management_system.entity.Student;


public interface StudentService {

	public List<Student> ShowListStudent();
	public void saveStudent(Student st);
	public Student getStudentById(int id);
	public void deleteStudent(Student st);
	public void updateStudent(Student sd);
}
