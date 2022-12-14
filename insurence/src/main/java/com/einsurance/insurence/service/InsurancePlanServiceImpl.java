package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.InsurancePlanalredyExistException;
import com.einsurance.insurence.exceptions.PlanNotPresentException;
import com.einsurance.insurence.exceptions.SchemeNotPresentException;
import com.einsurance.insurence.model.InsurancePlan;
import com.einsurance.insurence.model.InsuranceScheme;
import com.einsurance.insurence.repo.InsurancePlanRepository;

@Service
public class InsurancePlanServiceImpl implements InsurancePlanService {

	@Autowired
	InsurancePlanRepository insurancePlanRepository;
	
	@Autowired
	InsuranceSchemeService insuranceSchemeService;
	
	@Override
	public InsurancePlan addInsurancePlan(InsurancePlan insurancePlan) throws InsurancePlanalredyExistException, SchemeNotPresentException {
		List<InsuranceScheme> insuranceSchemes = insuranceSchemeService.getAllInsuranceScheme();
		Optional<InsuranceScheme> insuranceScheme = insuranceSchemes.stream().filter(e -> e.getInsuranceSchemeId() == insurancePlan.getInsuranceSchemeId()).findFirst();
		if(!insuranceScheme.isPresent()) {
			throw new SchemeNotPresentException();
		}
		List<InsurancePlan> listOfInsurancePlans = getAllInsurancePlan();
		Optional<InsurancePlan> plans = listOfInsurancePlans.stream()
				.filter(e -> e.getInsurancePlan().equals(insurancePlan.getInsurancePlan()) && e.getInsuranceSchemeId() == insurancePlan.getInsuranceSchemeId())
				.findFirst();
		if (plans.isPresent()) {
			throw new InsurancePlanalredyExistException();
		}
		return insurancePlanRepository.save(insurancePlan);
	}

	@Override
	public List<InsurancePlan> getAllInsurancePlan() {
		List<InsurancePlan> listOfPlans = insurancePlanRepository.findAll();
		return listOfPlans;
	}

	@Override
	public InsurancePlan getInsurancePlanById(long insurancePlanId) throws PlanNotPresentException {
		Optional<InsurancePlan> plan = insurancePlanRepository.findById(insurancePlanId);
		if (!plan.isPresent()) {
			throw new PlanNotPresentException();
		}
			return plan.get();
	}
	@Override
	public InsurancePlan updateInsurancePlan(InsurancePlan insurancePlan) throws PlanNotPresentException {
		InsurancePlan plan = getInsurancePlanById(insurancePlan.getInsurancePlanId());
		if(plan==null)
			throw new PlanNotPresentException();
		InsurancePlan saveInsurancePlan = insurancePlanRepository.save(insurancePlan);
		return saveInsurancePlan;
	}


}
