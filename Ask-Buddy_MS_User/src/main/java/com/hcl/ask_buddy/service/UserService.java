package com.hcl.ask_buddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.hcl.ask_buddy.entity.User_entity;
import com.hcl.ask_buddy.repository.User_repository;
import com.hcl.ask_buddy.security.JwtUserDetailsService;
import com.hcl.ask_buddy.security.JwtUtil;

@Service
public class UserService {
	
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
	
	
	public List<User_entity> user_List(){
		return user.findAll();
	}
	
	public boolean register(User_entity users) {
		try
		{
			users.setPassword(passwordEncoder.encode(users.getPassword()));
			user.save(users);
			System.out.println("sapId:"+users.getSap_Id()+"userName"+users.getUsername()+"passWord"+users.getPassword()+"dateOfJoining");
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	
	}
	
	public String login (long id ,String password) throws Exception{
		if(user.existsById(id))
		{
			User_entity userData = user.getById(id);
			authenticate(userData.getMail(), password);
			final UserDetails userDetails = userDetailsService.loadUserByUsername(userData.getMail());
			final String token = jwtTokenUtil.generateToken(userDetails);
//		    System.out.println(token);
			return token;
		}
		else
			return "Invalid User Id or Password";
	}
	
   //  User Authentication
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
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
