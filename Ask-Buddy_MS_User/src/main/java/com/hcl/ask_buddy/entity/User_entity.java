package com.hcl.ask_buddy.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "user")
public class User_entity {

	// User Entity Attributes
	@Id
	@Column(name = "sap_id")
	private long sap_Id;
	@Column(name = "user_mail")
	private String mail;
	@Column(name = "user_name")
	private String username;
	public long getSap_Id() {
		return sap_Id;
	}
	public void setSap_Id(long sap_Id) {
		this.sap_Id = sap_Id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public List<Answers> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answers> answerList) {
		this.answerList = answerList;
	}
	@Column(name = "password")
	private String password;
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Question> questionList;
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Answers> answerList;

}
