package com.studentManagement.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentManagement.entity.Student;
import com.studentManagement.services.StudentServices;

@Controller
public class StudentController {
	StudentServices ss;

	public StudentController(StudentServices ss) {
		super();
		this.ss = ss;
	}
	
	@GetMapping("/indexI")
	public String mapIndex() {
		return "index";
	}

	@GetMapping("/viewI")
	public String mapViewInfo() {
		return "viewInfo";
	}

	@GetMapping("/registerI")
	public String mapRegister() {
		return "register";
	}

	@GetMapping("/updateI")
	public String mapUpdateInfo() {
		return "updateInfo";
	}

	@GetMapping("/removeI")
	public String mapRemove() {
		return "remove";
	}

	@GetMapping("/showI")
	public String mapShow() {
		return "showInfo";
	}
	@PostMapping("/addStud")
	public String addStudent(@RequestParam("kodId")String kodId, @RequestParam("name")String name, @RequestParam("branch")String branch) {
		Student s = new Student(kodId,name,branch);
		ss.addStudent(s);
		return "index";
	}
	
	@PutMapping("/updStud")
	public String updateStudent(@RequestParam("kodId")String kodId, @RequestParam("name")String name, @RequestParam("branch")String branch) {
		Student st = ss.getStudent(kodId);
		st.setName(name);
		st.setBranch(branch);
		ss.updateStudent(st);
		return "index";
	}
	
	@DeleteMapping("/delStud")
	public String deleteStudent(@RequestParam("kodId")String kodId) {
		ss.deleteStudent(kodId);
		return "index";
	}
	
	@GetMapping("/getS")
	public String getStudent(@RequestParam("kodId")String kodId, Model model) {
		System.out.println(kodId);
		Student sts = ss.getStudent(kodId);
		System.out.println(sts);
		model.addAttribute("student", sts);
		return "showInfo";
	}
	
}
