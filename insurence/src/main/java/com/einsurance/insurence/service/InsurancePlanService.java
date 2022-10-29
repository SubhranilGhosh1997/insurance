package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.InsurancePlanalredyExistException;
import com.einsurance.insurence.exceptions.PlanNotPresentException;
import com.einsurance.insurence.model.InsurancePlan;

public interface InsurancePlanService {
	InsurancePlan addInsurancePlan(InsurancePlan insurencePlan) throws InsurancePlanalredyExistException;
	List<InsurancePlan> getAllInsurancePlan();
	InsurancePlan getInsurancePlanById(long insurancePlanId) throws PlanNotPresentException;
	InsurancePlan updateInsurancePlan(InsurancePlan insurancePlan)throws PlanNotPresentException;
}
