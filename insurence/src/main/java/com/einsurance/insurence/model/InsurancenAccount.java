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
public class InsurancenAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IaccountNumber;


	private long customerId;
	
	private long InsurancePlanId;
	
	private long InsuranceTypeId;
	
	private long InsuranceSchemeId;
	
	private String customerName;
	
	private long dateCreated;
	
	private long maturityDate;
	
	private int policyTerm;
	
	private double totalPremiumAmount;
	
	private double sumAssured;


}
