package com.hcl.ask_buddy.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	// DTO for User
	private long sap_Id;
	public User(long sap_Id, String mail, String username, String password) {
		super();
		this.sap_Id = sap_Id;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}
	private String mail;
	private String username;
	@JsonIgnore
	private String password;
	@JsonIgnore
	private List<Question> questionList;
	@JsonIgnore
	private List<Answers> answerList;

}
