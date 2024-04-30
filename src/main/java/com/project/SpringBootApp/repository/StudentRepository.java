package com.project.SpringBootApp.repository;

import com.project.SpringBootApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
