package com.application1.student_management_system.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.application1.student_management_system.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
