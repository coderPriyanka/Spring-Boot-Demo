package com.myproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentEntity {
	
	@Id
	private Integer rollNo;
	private String firstName;
	private String lastName;
	private String department;
	
	public Integer getRollNo() {
		return rollNo;
	}
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "StudentEntity [rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", department=" + department + "]";
	}

}
