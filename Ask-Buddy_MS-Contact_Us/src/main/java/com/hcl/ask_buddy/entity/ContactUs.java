package com.hcl.ask_buddy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class ContactUs {

	// ContactUs Entity Attributes
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sl;
	@NotNull
	@Column(name = "SAP_ID")
	private long sap_Id;
	@NotNull
	@Column(name = "Name", columnDefinition = "varchar(50)")
	private String name;
	@NotNull
	@Column(name = "Query", columnDefinition = "varchar(550)")
	private String query;
	@Column(name = "Status", columnDefinition = "boolean default false")
	private boolean que_status = false;

}
