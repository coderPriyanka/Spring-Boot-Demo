package com.myproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	List<StudentEntity> findByFirstName(String firstName);

	List<StudentEntity> findByLastName(String lastName);

}
