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
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	@NotNull
	@NotEmpty
	private String empoyeeName;
	@NotNull
	@NotEmpty
	@Email
	@Column(unique = true)
	private String emailId;
	@NotNull
	@NotEmpty
	private String password;
	@NotNull
	@NotEmpty
	private String status;
	@NotNull
	@NotEmpty
	private String employeeRole;
}
