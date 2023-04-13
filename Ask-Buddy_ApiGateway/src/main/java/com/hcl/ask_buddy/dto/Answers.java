package com.hcl.ask_buddy.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Answers {

	// DTO for the Answers 
	@JsonIgnore 
	private long id;
//	@JsonIgnore
	private Question question;
	private User user;
	private String description;
	private LocalDateTime date;	
//	private double noOfLikes;
//	private double noOfDisLikes;
	
}
