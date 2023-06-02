package com.studentManagement.services;

import java.util.List;

import com.studentManagement.entity.Student;

public interface StudentServices {
	String addStudent(Student s);

	Student getStudent(String kodId);

	List<Student> getAllStudents();

	String updateStudent(Student s);

	String deleteStudent(String kodId);
}
