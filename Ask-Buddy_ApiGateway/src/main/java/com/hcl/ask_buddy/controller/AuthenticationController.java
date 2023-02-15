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
//@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
	
	@Autowired
	UserService userService;
	
	// Controller for User Registration
	@PostMapping("/Register")
	public ResponseEntity<String> register(@RequestBody User user)
	{
		String msg = userService.register(user);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	// Controller for the User Login
	@PostMapping("/Login")
	@ApiParam(name = "HttpSession", value = "session", required = false)
	public String login(@RequestParam long id, @RequestParam String password)
	{
		System.out.println("coming here");
		return userService.login(id, password);
	}
	
	// Controller for the User Logout
	@PostMapping("/logout")
	public String logout(HttpSession session)
	{
		return userService.logout(session);
	}
}
