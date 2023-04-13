package com.hcl.ask_buddy.question.security;

import org.springframework.stereotype.Component;

import com.hcl.ask_buddy.question.entity.User;

import lombok.Data;

@Component
@Data
public class AuthenticatedUser {
	
	private User user;

}
