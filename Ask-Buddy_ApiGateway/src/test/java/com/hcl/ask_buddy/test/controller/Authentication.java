package com.hcl.ask_buddy.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.ask_buddy.entity.User;
import com.hcl.ask_buddy.repository.UserRepo;
import com.hcl.ask_buddy.security.JwtFilter;
import com.hcl.ask_buddy.security.JwtUtil;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class Authentication {
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserRepo userRepo;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void register() throws Exception
	{
		User user = new User(52112596, "Test3@gmail.com", "Test3", "Test3");
		given(userRepo.save(user)).willReturn(user);
		
		ResultActions result = mockMvc.perform(post("/register").contentType("application/json").content(objectMapper.writeValueAsString(user)));
		 
		System.out.print(result);
		result.andExpect(status().isOk())
		.andDo(print())
		.andExpect(status().is2xxSuccessful());
		
	}
	
	
	
	
	
}
