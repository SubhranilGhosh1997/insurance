package com.einsurance.insurence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;

	@NotNull
	@NotEmpty
	private String customerName;

	@NotNull
	@NotEmpty
	private String password;

	@NotNull
	@NotEmpty
	@Email
	@Column(unique = true)
	private String emailId;

	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[0-9]*", message = "only numbers allowed")
	@Size(min = 10, message = "can't be less then 10")
	@Size(max = 10, message = "can't be more then 13")
	private String contactNumber;

	private long dateOfBirth;

	@NotNull
	@NotEmpty
	private String state;

	@NotNull
	@NotEmpty
	private String city;

	private String address;

	@Pattern(regexp = "^[0-9]{6}", message = "only numbers allowd size 6 digit.")
	private String pincode;

	private String nomineeName;

	private String nomineeRelation;

	private String role;


}
