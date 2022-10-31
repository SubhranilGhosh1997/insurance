package com.einsurance.insurence.model;

import javax.persistence.Column;
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
public class InsuranceType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long insuranceTypeId;
	@NotBlank
	@Column(unique = true)
	private String insuranceType; 
	private String imageSrc;
	@NotBlank
	private String status;
}
