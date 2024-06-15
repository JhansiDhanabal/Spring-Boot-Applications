package com.application1.student_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.application1.student_management_system.entity.Student;
import com.application1.student_management_system.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}


	@Autowired
	StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Student st = new Student("Jhansi", "Rani", "jhansisna.22@gmail.com");
//		Student st1 = new Student("Nanda", "Gopal", "nandagopal@gmail.com");
//		Student st2 = new Student("Dhanabal", "Rohini", "dhanani.22@gmail.com");
//		
//		repository.save(st);
//		repository.save(st1);
//		repository.save(st2);
	}

}
