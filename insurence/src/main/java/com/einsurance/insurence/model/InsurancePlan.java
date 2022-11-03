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
public class InsurancePlan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long insurancePlanId;
	
	private long insuranceSchemeId;
	
	private long insuranceTypeId;
	@NotBlank
	private String insurancePlan;

	private int minumumPolicyTerm;
	
	private int maximumPolicyTerm;
	
	private int minimumAge;
	
	private int maximumAge;
	
	private double minimumInvestmentAmount;
	
	
	private double maximumInvestmentAmount;
	
	private double profitRatio;
	
	private String status; 

}
