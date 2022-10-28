package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.InsuranceSchemealredyExistException;
import com.einsurance.insurence.exceptions.SchemeNotPresentException;
import com.einsurance.insurence.model.InsurenceScheme;

public interface InsuranceSchemeService {
	InsurenceScheme addInsuranceScheme(InsurenceScheme insurenceScheme) throws InsuranceSchemealredyExistException;
	List<InsurenceScheme> getAllInsuranceScheme();
	InsurenceScheme getInsuranceSchemeById(long insurenceSchemeId) throws SchemeNotPresentException;
	InsurenceScheme updateStatusOfInsuranceSchemeById(String status,long insurenceSchemeId) throws SchemeNotPresentException;
}
