package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Auth;
import com.example.demo.model.JwtLogin;
import com.example.demo.service.TokenService;

@CrossOrigin("http://localhost:4200")
@RestController
public class Login { 
	@Autowired
	private TokenService tokenService;
	
	 @PostMapping("/signin")
	    public Auth login(@RequestBody JwtLogin login) {
		 //System.out.println(this.tokenService.Login(login));
	    	return new Auth(this.tokenService.Login(login));
	    }; 
}
