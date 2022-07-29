package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApiSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiSystemApplication.class, args); 
		
		 List<String> alpha = Arrays.asList("a", "b", "c", "d");
		 List<String> alphaUpper = new ArrayList<>();
	        System.out.println(alpha); 
	       
	        
	        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
	        System.out.println(collect); 
	        
			 List<Integer> num = Arrays.asList(1,3,4,5,6); 
			List<Integer> nums  =  num.stream().map(n -> n * 2).collect(Collectors.toList()); 
		        System.out.println(nums); 

	}

}
