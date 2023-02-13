package com.hcl.ask_buddy.dto;

import java.time.LocalDateTime;
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

public class Question {

	private long id;
	private User user;
	private String quesDescription;
	private LocalDateTime date;
	private Category cat;
	private Sub_Category subCat;
	@JsonIgnore
	private List<Answers> answerList;


}
