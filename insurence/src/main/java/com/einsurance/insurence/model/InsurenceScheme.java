package com.einsurance.insurence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class InsurenceScheme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long insuranceSchemeId;
	private long insuranceTypeId;
	private String insuranceScheme;
	private String image;
	private double commissionForNewRegistration;
	private double commissionForInstallmentPayment;
	private String note;
	private String Status;
}
