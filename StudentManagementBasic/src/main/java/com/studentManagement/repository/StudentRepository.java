package com.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentManagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}