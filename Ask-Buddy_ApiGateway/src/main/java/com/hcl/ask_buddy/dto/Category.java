package com.hcl.ask_buddy.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Category {
	
	// DTO for the Category 
	@JsonIgnore
	private long id;
	private String cat_name;
//	@JsonIgnore
//	private List<Question> questionList;
}
