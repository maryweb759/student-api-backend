package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Student;

public class StudentPojo {
	private Long count;
	private List<Student> student;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public StudentPojo(Long count, List<Student> student) {
		super();
		this.count = count;
		this.student = student;
	}
	public StudentPojo() {
		
	}
	
}
