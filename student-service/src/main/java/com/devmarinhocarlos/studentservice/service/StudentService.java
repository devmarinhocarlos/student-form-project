package com.devmarinhocarlos.studentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmarinhocarlos.studentservice.model.Student;
import com.devmarinhocarlos.studentservice.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repo;

	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	public Student getStudent(Long id) {
		return repo.findById(id).get();
	}

	public void setStudent(String firstName, String lastName, Integer age, Integer grade) {
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setAge(age);
		student.setGrade(grade);
		repo.save(student);
	}
}
