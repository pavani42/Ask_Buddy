package com.hcl.ask_buddy.answer.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "questions")
public class Question {

	// Question Entity Attributes
	@Id
	@Column(name = "que_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "sap_id")
	private User user;
	@Column(name = "question")
	private String question;
	@Column(name = "que_description", columnDefinition = "varchar(5000)")
	private String quesDescription;
	@Column(name = "que_date")
	private LocalDateTime date;
//	@Column(name = "likes")
//	private double noOfLikes;
//	@Column(name = "dislikes")
//	private double noOfDisLikes;
	@ManyToOne
	@JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
	private Category cat;
	@ManyToOne
	@JoinColumn(name = "subcat_id", referencedColumnName = "subcat_id")
	private Sub_Category subCat;
	@JsonIgnore
	@OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Answers> answerList;
	

}
