package com.einsurance.insurence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stateId;
	@NotBlank
	@Column(unique = true)
	private String state;
	@NotBlank
	private String status;
}
