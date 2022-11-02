package com.einsurance.insurence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Agent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long agentId;

	@NotNull
	@NotEmpty
	private String agentName;


	@NotNull
	@NotEmpty
	private String agentCode;
	
	@NotNull
	@NotEmpty
	private String password;

	@NotNull
	@NotEmpty
	@Email
	@Column(unique = true)
	private String emailId;

	private String agentAddress;

	private String qualification;

	private String status;

	private String role;

}
