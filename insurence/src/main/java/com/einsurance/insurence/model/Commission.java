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
public class Commission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commissionId;

	private long IaccountNumber;

	private long AgentId;
	
	//*commissionAmount
	
	private double commissionPercentage;

	private long commissionAccountId;

	private long commissionDate;

	
}
