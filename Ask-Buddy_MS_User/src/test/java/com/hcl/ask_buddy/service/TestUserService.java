package com.hcl.ask_buddy.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hcl.ask_buddy.entity.User_entity;
import com.hcl.ask_buddy.repository.User_repository;
import com.hcl.ask_buddy.security.JwtUserDetailsService;
import com.hcl.ask_buddy.security.JwtUtil;

@ExtendWith(MockitoExtension.class)
public class TestUserService {
	
	@Mock
	User_repository userRepo;
	
	@InjectMocks
	UserService userService;
	
	@Mock
	private JwtUserDetailsService userDetailsService;
	
	@Mock
	private AuthenticationManager authenticationManager;
	
	@Mock
	private PasswordEncoder passwordEncode;
	
	private String secret = "java";
	
	private PasswordEncoder passwordEncoder;
	
	@Mock
	private JwtUtil jwtTokenUtil;
	
	User_entity user;
	
	
	@BeforeEach
	public void setUp()
	{
		this.passwordEncoder = new BCryptPasswordEncoder();
		user = User_entity.builder().sap_Id(52112593).mail("test@gmail.com").
				username("test").password(passwordEncoder.encode("test")).build();
		
		this.jwtTokenUtil = new JwtUtil(secret);
	}
	
	@Test
	public void TestRegister()
	{ 
		Mockito.when(userRepo.save(Mockito.any(User_entity.class))).thenReturn(user);
		assertTrue(userService.register(user));
	}
	
	@Test
	public void TestInvalidLogin() throws Exception
	{
//		user.setPassword(passwordEncoder.encode("test"));
//		Mockito.when(userRepo.getById(user.getSap_Id())).thenReturn(user);
		assertNotNull(userService.login(user.getSap_Id(), user.getPassword()));
	}
	
	@Test
	public void TestvalidLogin() throws Exception
	{
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Mockito.when(userRepo.existsById(user.getSap_Id())).thenReturn(true);
		Mockito.when(userRepo.getById(user.getSap_Id())).thenReturn(user);
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		Mockito.when(userRepo.getByMail(user.getMail())).thenReturn(user);
		Mockito.when(userDetailsService.loadUserByUsername(user.getMail())).thenReturn
		(new org.springframework.security.core.userdetails.User(user.getMail(), user.getPassword(), new ArrayList<>()));
		assertNull(userService.login(user.getSap_Id(), "test"));
	}  
	
	
	@Test
	public void TestUser_List()
	{
		Mockito.when(userRepo.findAll()).thenReturn(null);
		assertNull(userService.user_List());
	}
}
