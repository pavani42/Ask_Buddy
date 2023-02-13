package com.hcl.ask_buddy.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.ask_buddy.dto.ContactUs;

@Service
public class ContactUs_Service {
	@Autowired
	private GenarateUrl generateUrl;

	@Autowired
	RestTemplate restTemplate;

	public String getUrl()
	{
		return generateUrl.getBaseUrl("ContactUs-MS");
	}
	
	public ContactUs addQuery(ContactUs contactUs)
	{
		return restTemplate.postForObject(getUrl() + "/contactUs/postQuery", contactUs, ContactUs.class);
	}
	
	public List<ContactUs> getAllQueries()
	{
		ContactUs[] contactUsList = restTemplate.getForObject(getUrl() + "/contactUs/getAllQueries", ContactUs[].class);
		return Arrays.asList(contactUsList);
	}
	
	public ContactUs updateQuery(ContactUs contactUs)
	{
		return restTemplate.postForObject(getUrl() + "/contactUs/UpdateQuery", contactUs, ContactUs.class);
	}
	
	public ContactUs getBySapId(long sap_Id)
	{
		return restTemplate.getForObject(getUrl() + "/contactUs/sapId/" + sap_Id, ContactUs.class);
	}

}
