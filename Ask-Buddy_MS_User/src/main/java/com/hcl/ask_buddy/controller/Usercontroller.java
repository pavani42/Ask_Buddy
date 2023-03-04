package com.hcl.ask_buddy.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ask_buddy.entity.*;
import com.hcl.ask_buddy.repository.*;
import com.hcl.ask_buddy.security.JwtUserDetailsService;
import com.hcl.ask_buddy.security.JwtUtil;
import com.hcl.ask_buddy.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

// User APIs Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Usercontroller {
	@Autowired
	UserService userService;
	// Controller for FetchingAll  Users
	@GetMapping("/user")
	public List<User_entity> user_List(){
		return userService.user_List();
	}
	
	// Controller for Adding User
	@PostMapping("/register")
	public boolean register(@RequestBody User_entity users) {
		return userService.register(users);
	}
	
	// Controller for User Login
	@GetMapping("/login")
	public ResponseEntity<String> login (@RequestParam long id , @RequestParam String password) throws Exception{
		return ResponseEntity.ok(userService.login(id, password));	
	} 
	
	

	// Controller for Deleting by ID
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return userService.delete(id);
	}
	
	@GetMapping("/logout")
	public void logout()
	{
		
	}
}
