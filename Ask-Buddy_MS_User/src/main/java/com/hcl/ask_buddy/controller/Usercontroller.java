package com.hcl.ask_buddy.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.ask_buddy.entity.*;
import com.hcl.ask_buddy.repository.*;
import com.hcl.ask_buddy.security.JwtUserDetailsService;
import com.hcl.ask_buddy.security.JwtUtil;
import com.hcl.ask_buddy.service.UserService;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

// User APIs Controller
@RestController
@RequestMapping("/api/users")
//@CrossOrigin(origins = "http://localhost:3000")
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
	
	// Controller for updating password
	@PutMapping("/updatePassword")
	public String updatePassword(@RequestParam String mail, @RequestParam long sap_id, @RequestParam String password)
	{
		return userService.updatePassword(mail, sap_id, password);
	}
	
	@GetMapping("/logout")
	public void logout()
	{
		
	}
	
	@GetMapping("/generateOtp")
	public String generateOtp(long sap_id) throws MailSendException, AddressException, MessagingException
	{
		return userService.generateOtp(sap_id);
	}
	
	@GetMapping("/verifyOtp")
	public User_entity verifyOtp(@RequestParam long sap_id, @RequestParam String otp)
	{
		return userService.verifyOtp(sap_id, otp);
	}
	
	@GetMapping("/getUserData")
	public User_entity getUserData(@RequestParam String token)
	{
		return userService.getUserData(token);
	}
	
	@PutMapping("/uploadImage")
	public int uploadImage(@RequestParam MultipartFile img) throws IOException
	{
		return userService.uploadImage(img);
	}
	
	@GetMapping("/getImage")
	public byte[] getImage(@RequestParam long sap_Id)
	{
		return userService.getImage(sap_Id);
	}
}
