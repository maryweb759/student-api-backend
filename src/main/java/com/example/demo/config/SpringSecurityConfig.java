package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.jwt.JwtAuthenticationFilter;
import com.example.demo.jwt.JwtAuthorizationFilter;

@Configuration 
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{ 
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("meriem").password(passwordEncoder().encode("123456")).roles("AMIN");
	}
	
	@Bean()
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable()  
		    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		    .and()
		    .addFilter(new JwtAuthenticationFilter(authenticationManager()))
		    .addFilter(new JwtAuthorizationFilter(authenticationManager()))
		    .authorizeRequests() 
		    .antMatchers(HttpMethod.POST, "/signin").permitAll()
            .antMatchers(HttpMethod.POST,"/login").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // if Method.OPTIONS allow access
		    .anyRequest().authenticated() // for all other request , they must be logged in
		    .and()
		    .httpBasic();
					
	} 
	
	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

 }
