package com.hcl.ask_buddy.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.ask_buddy.dto.User;
import com.hcl.ask_buddy.security.AuthenticatedUser;

// User Services
@Service
public class UserService {

	@Autowired
	private GenarateUrl generateUrl;

	@Autowired
	RestTemplate restTemplate;
	

	public String getUrl()
	{
		return generateUrl.getBaseUrl("User-MicroService");
	}

	// Service for Adding User
	public String register(User user)
	{
		
		if(restTemplate.postForObject(getUrl() + "/api/users/register", user, boolean.class))
			return "Successfully Registered";
		else
			return "User Already Exists";	
	}

	// Service for User Login
	public ResponseEntity<String> login(long id, String password)
	{
		ResponseEntity<String> result = restTemplate.getForEntity(getUrl() + "/api/users/login?id=" + id + "&password=" + password, String.class);
		return result;
	}  
	// Service for User Logout
	public String logout(HttpSession session)
	{
		session.removeAttribute("id");
		return "Successfully logout";
	}

	public String updatePassword(String mail, long sap_id, String password) {
		String msg = restTemplate.exchange(getUrl() + "/api/users/updatePassword?mail=" + mail + "&password=" + password + "&sap_id=" +sap_id , HttpMethod.PUT, new HttpEntity<>(null), String.class).getBody();
		return msg;
	}

	public static User getUserData(String token) {
		
		return null;
	}

}
