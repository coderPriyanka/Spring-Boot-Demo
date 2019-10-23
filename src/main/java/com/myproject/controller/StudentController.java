package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.Student;
import com.myproject.service.StudentService;
//This is a Student Controller
@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/roll/{roll}")
	public Student getStudentByRoll(@PathVariable final Integer roll) {
		return studentService.getStudentById(roll);
	}
	
	@GetMapping("/firstname/{firstName}")
	public List<Student> getStudentsByFirstName(@PathVariable final String firstName) {
		return studentService.getStudentByFirstName(firstName);
	}
	
	@GetMapping("/lastname/{lastName}")
	public List<Student> getStudentsByLastName(@PathVariable final String lastName) {
		return studentService.getStudentByLastName(lastName);
	}
	
	@PostMapping
	public void addStudent(@RequestBody final Student student) {
		studentService.add(student);
	}
	
	@DeleteMapping("/{roll}") 
	public void deleteStudent(@PathVariable("roll") final Integer roll) {
		studentService.deleteStudent(roll);
	}
	
	@PutMapping(value = "/{id}/{department}")
	public void updateDepartment(@PathVariable("id") final Integer roll, @PathVariable("department") final String department) {
		studentService.updateDepartment(roll, department);
	}

}
