package com.einsurance.insurence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long feedbackId;
	
	private long customerId;
	
	@NotBlank
	private String customerName;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String message;
	
	private long contactDate;
	
	private String reply;
}
