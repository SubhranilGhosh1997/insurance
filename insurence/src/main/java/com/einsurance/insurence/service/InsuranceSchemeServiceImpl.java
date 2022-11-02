package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.InsuranceSchemealredyExistException;
import com.einsurance.insurence.exceptions.InsuranceTypeNotPresentException;
import com.einsurance.insurence.exceptions.SchemeNotPresentException;
import com.einsurance.insurence.model.InsuranceScheme;
import com.einsurance.insurence.model.InsuranceType;
import com.einsurance.insurence.repo.InsuranceSchemeRepository;

@Service
public class InsuranceSchemeServiceImpl implements InsuranceSchemeService {

	@Autowired
	InsuranceSchemeRepository insuranceSchemeRepository;

	@Autowired
	InsuranceTypeService insuranceTypeService;
	@Override
	public InsuranceScheme addInsuranceScheme(InsuranceScheme insuranceScheme) throws InsuranceSchemealredyExistException, InsuranceTypeNotPresentException {
		List<InsuranceType> allInsuranceTypes = insuranceTypeService.getAllInsuranceTypes();
		Optional<InsuranceType> insuranceType = allInsuranceTypes.stream().filter(e -> e.getInsuranceTypeId() == insuranceScheme.getInsuranceTypeId()).findFirst();
		if(!insuranceType.isPresent()) {
			throw new InsuranceTypeNotPresentException();
		}
		List<InsuranceScheme> listOfInsuranceSchemes = getAllInsuranceScheme();
		Optional<InsuranceScheme> schemes = listOfInsuranceSchemes.stream().filter(e -> e.getInsuranceScheme().equals(insuranceScheme.getInsuranceScheme())&& e.getInsuranceTypeId() == insuranceScheme.getInsuranceTypeId())
				.findFirst();
		if (schemes.isPresent()) {
			throw new InsuranceSchemealredyExistException();
		}
		return insuranceSchemeRepository.save(insuranceScheme);
	}

	@Override
	public List<InsuranceScheme> getAllInsuranceScheme() {
		List<InsuranceScheme> listOfSchemes = insuranceSchemeRepository.findAll();
		return listOfSchemes;
	}

	@Override
	public InsuranceScheme getInsuranceSchemeById(long insuranceSchemeId) throws SchemeNotPresentException {
		Optional<InsuranceScheme> scheme = insuranceSchemeRepository.findById(insuranceSchemeId);
		if (!scheme.isPresent()) {
			throw new SchemeNotPresentException();
		}
			return scheme.get();
	}

	@Override
	public InsuranceScheme updateInsuranceScheme(InsuranceScheme insuranceScheme) throws SchemeNotPresentException {
		InsuranceScheme scheme = getInsuranceSchemeById(insuranceScheme.getInsuranceSchemeId());
		if (scheme ==null) {
			throw new SchemeNotPresentException();
		}
		InsuranceScheme saveScheme = insuranceSchemeRepository.save(insuranceScheme);
		return saveScheme;
	}

	@Override
	public List<InsuranceScheme> getActiveInsurenceSchemeList() {
		List<InsuranceScheme> allInsuranceScheme = getAllInsuranceScheme();
		List<InsuranceScheme> activeInsuranceSchemes = allInsuranceScheme.stream().filter(e->e.getStatus().equalsIgnoreCase("active")).collect(Collectors.toList());
		return activeInsuranceSchemes;
	}

}
