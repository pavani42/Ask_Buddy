package com.hcl.ask_buddy.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hcl.ask_buddy.dto.User;
import com.hcl.ask_buddy.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/register", consumes = {"application/json"})
	public ResponseEntity<String> register(@RequestBody User user)
	{
		String msg = userService.register(user);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
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
	
	@PostMapping("/logout")
	public String logout(HttpSession session)
	{
		return userService.logout(session);
	}
	
	
}
