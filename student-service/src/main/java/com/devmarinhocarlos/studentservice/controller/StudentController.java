package com.devmarinhocarlos.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devmarinhocarlos.studentservice.model.Student;
import com.devmarinhocarlos.studentservice.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {
	@Autowired
	StudentService service;

	@GetMapping(value = "students/all")
	public List<Student> all() {
		return service.getAllStudents();
	}

	@GetMapping(value = "students/{id}")
	public Student findStudent(@PathVariable Long id) {
		return service.getStudent(id);
	}

	@PostMapping(value = "students/save")
	public String insertStudent(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam Integer age, @RequestParam Integer grade) {
		service.setStudent(firstName, lastName, age, grade);
		return "Saved";
	}

}
