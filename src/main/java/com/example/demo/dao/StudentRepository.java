package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.util.Streamable;

import com.example.demo.model.Student;
@Repository
//@RepositoryRestResource(collectionResourceRel = "stud", path = "student_list")
// http://localhost:8080/api/students -> get all data
// collectionResourceRel = "stud" -> change th name of arrayList 
// path = "student_list" -> change the api from students to student_list
//@CrossOrigin("http://localhost:4200")
//@RepositoryRestResource
public interface StudentRepository  extends JpaRepository<Student,Long> {
	@Query("select s FROM student s WHERE s.fullName LIKE %?1%")
  public Page<Student>  findByFullName(String fullname, Pageable listing); 
  // if we put %?1% means fullname contains 
	// if we put ?1% means fullname end with 
	// if we put %?1 means fullname starts with 
	@Query("select COUNT(id) FROM student  WHERE fullName LIKE %?1%")
	  public Long  findByFullName(String fullname); 
	  
  @Query("select COUNT(id) from student")
  public Long getStudentsCount();
  
  
 // public List<Student> findByFullNameContaining(String fullname);

}
