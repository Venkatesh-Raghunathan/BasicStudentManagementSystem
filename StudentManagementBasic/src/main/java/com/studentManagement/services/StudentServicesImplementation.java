package com.studentManagement.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.studentManagement.entity.Student;
import com.studentManagement.repository.StudentRepository;

@Service
public class StudentServicesImplementation implements StudentServices {
	StudentRepository srepo;

	public StudentServicesImplementation(StudentRepository srepo) {
		this.srepo = srepo;
	}

	@Override
	public String addStudent(Student s) {
		srepo.save(s);
		return "Student added";
	}

	@Override
	public Student getStudent(String kodId) {
		Student st = srepo.findById(kodId).get();
		return st;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> slist = srepo.findAll();
		return slist;
	}

	@Override
	public String updateStudent(Student s) {
		srepo.save(s);
		return "Student updated";
	}

	@Override
	public String deleteStudent(String kodId) {
		srepo.deleteById(kodId);
		return "Student deleted";
	}

}
