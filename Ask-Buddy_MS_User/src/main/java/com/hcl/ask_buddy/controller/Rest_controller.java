package com.hcl.ask_buddy.controller;

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
public class Rest_controller {
	@Autowired 
	User_repository user;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	

	// Controller for FetchingAll  Users
	@GetMapping("/User")
	public List<User_entity> user_List(){
		return user.findAll();
	}
	
	// Controller for Adding User
	@PostMapping("/register")
	public boolean check(@RequestBody User_entity users) {
		try
		{
			users.setPassword(passwordEncoder.encode(users.getPassword()));
			user.save(users);
			System.out.println("sapId:"+users.getSap_Id()+"userName"+users.getUsername()+"passWord"+users.getPassword()+"dateOfJoining");
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	
	}
	
	// Controller for User Login
	@GetMapping("/login")
	public ResponseEntity<String> login (@RequestParam long id , @RequestParam String password) throws Exception{
		if(user.existsById(id))
		{
			User_entity userData = user.getById(id);
		//		System.out.println(userData.getPassword());
			authenticate(userData.getMail(), password);
			System.out.println(userData.getPassword());
			final UserDetails userDetails = userDetailsService.loadUserByUsername(userData.getMail());
			final String token = jwtTokenUtil.generateToken(userDetails);
		
			return ResponseEntity.ok(token);
		}
		else
			return ResponseEntity.ok("Given Id is invalid");

		
	}
	
	//  Controller for User Authentication
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	// Controller for Deleting by ID
	@GetMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		try
		{
			user.deleteById(id);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
}
