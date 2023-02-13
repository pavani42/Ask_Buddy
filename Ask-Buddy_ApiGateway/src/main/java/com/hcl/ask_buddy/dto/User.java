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
	private long sap_Id;
	@JsonIgnore
	private String mail;
	private String username;
	@JsonIgnore
	private String password;
	@JsonIgnore
	private List<Question> questionList;
	@JsonIgnore
	private List<Answers> answerList;

}
