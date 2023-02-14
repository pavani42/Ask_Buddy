package com.hcl.ask_buddy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactUs {

	// DTO for ContactUs 
	private long sap_Id;
	private String name;
	private String query;
	private boolean que_status = false;

}
