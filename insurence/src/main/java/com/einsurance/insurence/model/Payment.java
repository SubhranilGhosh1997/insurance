package com.einsurance.insurence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;

	private long IAccountNumber;
	
	private int installmentNo;
	
	private long installmentDate;
	
	private double installmentAmount;
	
	private String paymentStatus;
	
	private long paidDate;
	
	private long dummyAccountNumber;
	
	private double taxAmount;
	

}
