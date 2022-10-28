package com.einsurance.insurence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Documents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String docType; 
	private String sourcePath;
	private long customerId;
}
