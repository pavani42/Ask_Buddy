package com.hcl.ask_buddy.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

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
@Entity
@Table(name = "answers")
public class Answers {

	//Answer Entity Attributes
	
	@Id
	@Column(name = "ans_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private double id;
	@ManyToOne
	@JoinColumn(name = "que_id", referencedColumnName = "que_id")
	private Question question;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "sap_id")
	private User user;
	@Column(name = "ans_description")
	private String description;
	@Column(name = "ans_date")
	private LocalDateTime date;	
//	@Column(name = "likes")
//	private double noOfLikes;
//	@Column(name = "dislikes")
//	private double noOfDisLikes;
	
}
