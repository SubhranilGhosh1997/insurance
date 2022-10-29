package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.InsuranceSchemealredyExistException;
import com.einsurance.insurence.exceptions.SchemeNotPresentException;
import com.einsurance.insurence.model.InsuranceScheme;
import com.einsurance.insurence.repo.InsuranceSchemeRepository;

@Service
public class InsuranceSchemeServiceImpl implements InsuranceSchemeService {

	@Autowired
	InsuranceSchemeRepository insuranceSchemeRepository;

	@Override
	public InsuranceScheme addInsuranceScheme(InsuranceScheme insuranceScheme) throws InsuranceSchemealredyExistException {
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

}
