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
public class DummyAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNo;
	
	private String cardholderName;

	private String cardNumber;

	private int CVV;
	
	private double balance;

	private long expiryDate;


	
}
