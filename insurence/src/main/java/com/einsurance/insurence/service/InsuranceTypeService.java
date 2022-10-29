package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.InsuranceAlreadyExistsException;
import com.einsurance.insurence.exceptions.InsuranceTypeNotPresentException;
import com.einsurance.insurence.model.InsuranceType;

public interface InsuranceTypeService {

	InsuranceType addInsuranceType(InsuranceType insuranceType) throws InsuranceAlreadyExistsException;
	List<InsuranceType> getAllInsuranceTypes();
	InsuranceType updateInsuranceType(InsuranceType insuranceType) throws InsuranceTypeNotPresentException;
	InsuranceType getInsuranceTypeById(long insuranceTypeId) throws InsuranceTypeNotPresentException;
	
}
