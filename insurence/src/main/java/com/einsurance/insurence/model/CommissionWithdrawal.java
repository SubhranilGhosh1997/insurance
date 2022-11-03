package com.einsurance.insurence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CommissionWithdrawal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commissionWithdrawalId;

	private long commissionAccountId;

	private double withdrawnAmount;

	private long requestDate;
	
	private double updatedAmount;
	
	private String particular;
	
	private String status;

	
}
