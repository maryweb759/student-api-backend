package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.StudentRepository;
import com.example.demo.dto.StudentPojo;
import com.example.demo.model.Student;

@Service
public class StudentService {
	 @Autowired
	private StudentRepository studentRepository;

	 public List<Student> getStudents(){
	        return studentRepository.findAll();
	    } 
	 
//	 public List<Student> getAllStudents(int page, int size){ 
//		 Pageable listing = PageRequest.of(page, size);;
//	        return studentRepository.findAll(listing).getContent();
//	    } 
	 public StudentPojo getAllStudents(int page, int size){ 
		 Pageable listing = PageRequest.of(page, size);;
		 StudentPojo studentPojo = new StudentPojo();
		 Page<Student> st =  studentRepository.findAll(listing);
		 studentPojo.setCount(st.getTotalElements());
		 studentPojo.setStudent(st.getContent());
	        return studentPojo;
	    }
	 
	    public Student getStudentById (Long id){
	        return studentRepository.findById(id).get();
	    } 
	 
	    public Student saveStudent(Student student){
	        return studentRepository.save(student);
	    } 
	  
	    public Student updateStudent(Student student){
	        return studentRepository.save(student);
	    } 
	
	    public void removeStudent(@RequestParam Long id){
	         studentRepository.deleteById(id);;
	    } 
	    
	    public StudentPojo  findByFullName(String fullName, int page, int size) {
			 Pageable listing = PageRequest.of(page, size); 
			 StudentPojo studentPojo = new StudentPojo();
			 Page<Student> st =  studentRepository.findByFullName(fullName, listing);
			 studentPojo.setCount(st.getTotalElements());
			 studentPojo.setStudent(st.getContent());
		       return studentPojo;
	    	//return studentRepository.findByFullName(fullName, listing);
	    };

	    public Long getStudentsCount() {
	    	return studentRepository.getStudentsCount();
	    } 
	    
		  public Long  findByFullName(String fullname) {
		    	return studentRepository.findByFullName(fullname);
		  }

}
