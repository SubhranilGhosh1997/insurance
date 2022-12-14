package com.einsurance.insurence.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.einsurance.insurence.exceptions.InsuranceAlreadyExistsException;
import com.einsurance.insurence.exceptions.InsuranceTypeNotPresentException;
import com.einsurance.insurence.model.InsuranceType;

@Component
public interface InsuranceTypeService {

	InsuranceType addInsuranceType(InsuranceType insuranceType) throws InsuranceAlreadyExistsException;

	String addInsuranceTypeImage(long insuranceTypeId, MultipartFile file, String path)
			throws InsuranceTypeNotPresentException;

	List<InsuranceType> getAllInsuranceTypes();
	
	List<InsuranceType> getActiveInsuranceTypes();

	InsuranceType updateInsuranceType(InsuranceType insuranceType) throws InsuranceTypeNotPresentException;

	InsuranceType getInsuranceTypeById(long insuranceTypeId) throws InsuranceTypeNotPresentException;

}
