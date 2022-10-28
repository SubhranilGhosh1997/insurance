package com.einsurance.insurence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class InsurancePlan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long insurancePlanId;
	
	@NotBlank
	private long InsuranceSchemeId;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]*", message = "only numbers allowed")
	private int minumumPolicyTerm;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]*", message = "only numbers allowed")
	private int maximumPolicyTerm;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]*", message = "only numbers allowed")
	private int minimumAge;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]*", message = "only numbers allowed")
	private int maximumAge;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]*", message = "only numbers allowed")
	private double minimumInvestmentAmount;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]*", message = "only numbers allowed")
	private double maximumInvestmentAmount;
	
	@NotBlank	
	private double profitRatio;
	
	private String status;

}
