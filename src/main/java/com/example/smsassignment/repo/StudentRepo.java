package com.example.smsassignment.repo;

import com.example.smsassignment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepo extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
}
