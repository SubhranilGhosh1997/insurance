package com.einsurance.insurence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class InsuranceScheme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long insuranceSchemeId;
	@NotBlank
	private long insuranceTypeId;
	@NotBlank
	private String insuranceScheme;
	private String image;
	private double commissionForNewRegistration;
	private double commissionForInstallmentPayment;
	private String note;
	@NotBlank
	private String Status;
}