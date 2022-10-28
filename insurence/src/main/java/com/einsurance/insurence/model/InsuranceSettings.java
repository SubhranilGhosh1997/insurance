package com.einsurance.insurence.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class InsuranceSettings {

	@Id
	private long insuranceSettingId;
	private double claimDeductionPercentage;
	private double penaltyAmountPercentage;
	private double taxPercentage;
}
