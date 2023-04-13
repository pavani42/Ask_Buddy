package com.hcl.ask_buddy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Joinus {

	@Id
	@NotNull
	@Digits(integer = 8, fraction = 0)
	private long sapId;
	@NotNull
	@Column(name = "Name", columnDefinition = "varchar(150)")
	private String name;
	@NotNull
	@Email
	private String email;
	@NotNull
	private String gender;
	@NotNull
	@Column(name = "Trained_ing", columnDefinition = "varchar(550)")
	private String Trained;
	@NotNull
	private String SkillsSet;
	@NotNull
	@Column(columnDefinition = "varchar(650)")
	private String aboutU;
	private String Remarks;
	@Column(name = "Status", columnDefinition = "boolean default false")
	private boolean que_status ;

}
