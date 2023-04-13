package com.hcl.ask_buddy.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hcl.ask_buddy.dto.User;
import com.hcl.ask_buddy.service.UserService;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
	
	@Autowired
	UserService userService;
	
	
	// Controller for User Registration
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user)
	{
		String msg = userService.register(user);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	// Controller for the User Login
	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestParam long id, @RequestParam String password)
	{
		System.out.println("coming here");
		try
		{
		  return userService.login(id, password);
		}
		catch(Exception e)
		{
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	// Controller for the User Logout
	@PostMapping("/logout")
	public String logout(HttpSession session)
	{
		return userService.logout(session);
	}
	
	@PutMapping("/updatePassword")
	public String updatePassword(@RequestParam String mail, @RequestParam long sap_id, @RequestParam String password)
	{
		return userService.updatePassword(mail, sap_id, password);
	}
	
	@GetMapping("/GetUserData")
	public User getUserData(@RequestParam String token)
	{
		return UserService.getUserData(token);
	}
	
	
}
