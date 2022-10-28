package com.einsurance.insurence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class InsurancePlan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long insurancePlanId;
	
	private long InsuranceTypeId;
	private long InsuranceSchemeId;
	private int minumumPolicyTerm;
	private int maximumPolicyTerm;
	private int minimumAge;
	private int maximumAge;
	private double minimumInvestmentAmount;
	private double maximumInvestmentAmount;
	private double profitRatio;
	private String status;

}
