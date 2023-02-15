package com.hcl.ask_buddy.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.ask_buddy.dto.User;

// User Services
@Service
public class UserService {

	@Autowired
	private GenarateUrl generateUrl;

	@Autowired
	RestTemplate restTemplate;

	public String getUrl()
	{
		return generateUrl.getBaseUrl("User_MicroService");
	}

	// Service for Adding User
	public String register(User user)
	{
		if(restTemplate.postForObject(getUrl() + "/register", user, boolean.class))
			return "Successfully Registered";
		else
			return "User Already Exists";	
	}

	// Service for User Login
	public String login(long id, String password)
	{
//		if(restTemplate.getForObject(getUrl() + "/login?id=" + id + "&password=" + password, String.class) != null)
//		{
////			session.setAttribute("id", id);
//			return "login Successfully";
//		}
//		else
//			return "Invalid Login Details";
		return restTemplate.getForObject(getUrl() + "/login?id=" + id + "&password=" + password, String.class);
	}

	// Service for User Logout
	public String logout(HttpSession session)
	{
		session.removeAttribute("id");
		return "Successfully logout";
	}

}
