package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.InsurenceSchemealredyExistException;
import com.einsurance.insurence.exceptions.SchemeNotPresentException;
import com.einsurance.insurence.model.InsurenceScheme;

public interface InsurenceSchemeService {
	InsurenceScheme addInsuranceScheme(InsurenceScheme insurenceScheme) throws InsurenceSchemealredyExistException;
	List<InsurenceScheme> getAllInsuranceScheme();
	InsurenceScheme getInsuranceSchemeById(long insurenceSchemeId) throws SchemeNotPresentException;
	InsurenceScheme updateStatusOfInsuranceSchemeById(String status,long insurenceSchemeId) throws SchemeNotPresentException;
}
