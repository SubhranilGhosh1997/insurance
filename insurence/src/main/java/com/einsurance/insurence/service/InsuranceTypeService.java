package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.InsuranceAlreadyExistsException;
import com.einsurance.insurence.model.InsuranceType;

public interface InsuranceTypeService {

	InsuranceType addInsuranceType(InsuranceType insuranceType) throws InsuranceAlreadyExistsException;
	List<InsuranceType> getAllInsuranceTypes();
	
}
