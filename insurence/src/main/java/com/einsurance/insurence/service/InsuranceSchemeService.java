package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.InsuranceSchemealredyExistException;
import com.einsurance.insurence.exceptions.SchemeNotPresentException;
import com.einsurance.insurence.model.InsuranceScheme;

public interface InsuranceSchemeService {
	InsuranceScheme addInsuranceScheme(InsuranceScheme insuranceScheme) throws InsuranceSchemealredyExistException;
	List<InsuranceScheme> getAllInsuranceScheme();
	InsuranceScheme getInsuranceSchemeById(long insuranceScheme) throws SchemeNotPresentException;
	InsuranceScheme updateInsuranceScheme(InsuranceScheme insuranceScheme) throws SchemeNotPresentException;
}
