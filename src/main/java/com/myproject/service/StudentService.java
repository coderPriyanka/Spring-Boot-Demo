package com.myproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myproject.entity.StudentEntity;
import com.myproject.model.Student;
import com.myproject.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	private ModelMapper mapper = new ModelMapper();

	public List<Student> getAllStudents() {
		List<StudentEntity> studentEntities = studentRepository.findAll();
		List<Student> students = new ArrayList<Student>();
		for (StudentEntity entity : studentEntities) {
			students.add(mapper.map(entity, Student.class));
		}
		return students;
	}

	public Student getStudentById(Integer roll) {
		Optional<StudentEntity> studentEntity = studentRepository.findById(roll);
		if(studentEntity.isPresent()) {
			return mapper.map(studentEntity.get(), Student.class);
		}
		return null;
	}

	public List<Student> getStudentByFirstName(String firstName) {
		List<StudentEntity> studentEntities = studentRepository.findByFirstName(firstName);
		List<Student> students = new ArrayList<Student>();
		for (StudentEntity entity : studentEntities) {
			students.add(mapper.map(entity, Student.class));
		}
		return students;
	}

	public List<Student> getStudentByLastName(String lastName) {
		List<StudentEntity> studentEntities = studentRepository.findByLastName(lastName);
		List<Student> students = new ArrayList<Student>();
		for (StudentEntity entity : studentEntities) {
			students.add(mapper.map(entity, Student.class));
		}
		return students;
	}

	public void add(Student student) {
		StudentEntity studentEntity = mapper.map(student, StudentEntity.class);
		studentRepository.save(studentEntity);
		
	}

	public void deleteStudent(Integer roll) {
		studentRepository.deleteById(roll);
	}

	public void updateDepartment(Integer roll, String department) {
		Optional<StudentEntity> studentEntity = studentRepository.findById(roll);
		if (studentEntity.isPresent()) {
			Student student = mapper.map(studentEntity, Student.class);
			student.setDepartment(department);
			studentRepository.save(mapper.map(student, StudentEntity.class));
		}
	}

}
