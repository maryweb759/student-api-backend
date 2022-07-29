package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Auth;
import com.example.demo.model.Student;

@CrossOrigin("http://localhost:4200")
@RestController
public class BasicAuthenticationController {

	 @GetMapping("/authenticate")
	    public Auth findByFullName() {
	    	return new Auth("user authonticated");
	    }; 
	    
//	    @GetMapping("/main")
//	    public String Main(){
//	        return "yes";
//	    }
}
