package com.hcl.ask_buddy.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Question {

	// DTO for the Question

	private long id;
	public Question(long id, User user2, String quesDescription, LocalDateTime date, Category cat, Sub_Category subCat) 
	{
		super();
		this.id = id;
		this.user = user2;
		this.quesDescription = quesDescription;
		this.date = date;
		this.cat = cat;
		this.subCat = subCat;
	}
	private User user;
	private String quesDescription;
	private String question;
	private LocalDateTime date;
	private Category cat;
	private Sub_Category subCat;
	@JsonIgnore
	private List<Answers> answerList;
//	private double noOfLikes;
//	private double noOfDisLikes;


}
