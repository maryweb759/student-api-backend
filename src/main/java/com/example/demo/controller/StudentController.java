package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentPojo;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("system/")
public class StudentController {
	 @Autowired
	 private StudentService studentService;
	 
	// http://localhost:8080/system/students?page=0&size=1
//	    @GetMapping("students")
//	    public List<Student> getStudents(int page, int size){
//	        return studentService.getAllStudents(page, size);
//	    }
	 @GetMapping("students")
	    public StudentPojo getStudents(int page, int size){
	        return studentService.getAllStudents(page, size);
	    }
	    // http://localhost:8080/system/student?id=12
	    @GetMapping("student")
	    public Student getStudentById (@RequestParam Long id){
	        return studentService.getStudentById(id);
	    } 
	    
	    // http://localhost:8080/system/students
	    @PostMapping("students")
	    public Student saveStudent(@RequestBody Student student){
	        return studentService.saveStudent(student);
	    } 
	    
	 // http://localhost:8080/system/students?id=1
	    @PutMapping("students")
	    public Student updateStudent(@RequestBody Student student, @RequestParam Long id){
	        return studentService.updateStudent(student);
	    }  
	    
	    @DeleteMapping("students")
	    public void deleteStudentById(@RequestParam Long id){
	         studentService.removeStudent(id);
	    } 
	    
// http://localhost:8080/system/students/searchName?fullName=ma&page=0&size=5
	    @GetMapping("students/searchName")
	    public StudentPojo findByFullName(@RequestParam String fullName, 
	    	@RequestParam int page,@RequestParam int size) {
	    	return this.studentService.findByFullName(fullName, page, size);
	    }; 
//	    @GetMapping("students/searchName")
//	    public List<Student> findByFullName(@RequestParam String fullName, 
//	    	@RequestParam int page,@RequestParam int size) {
//	    	return this.studentService.findByFullName(fullName, page, size);
//	    }; 
	    
		 // http://localhost:8080/system/students/count
	    @GetMapping("students/count")
	    public Long getStudentsCount() {
	    	return this.studentService.getStudentsCount();
	    } 
		 // http://localhost:8080/system/students/countbyFullname?fullname=joh
	    @GetMapping("students/countbyFullname")
	    public Long  findByFullName(@RequestParam String fullname) {
	    	return studentService.findByFullName(fullname);
	  }  
	    
	    @GetMapping("/main")
	    public String Main(){
	        return "yes";
	    }
	    
}
