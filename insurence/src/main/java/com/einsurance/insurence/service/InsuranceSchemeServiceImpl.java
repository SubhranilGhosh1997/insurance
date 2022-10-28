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
	InsuranceSchemeRepository insurenceSchemeRepository;

	@Override
	public InsuranceScheme addInsuranceScheme(InsuranceScheme insurenceScheme) throws InsuranceSchemealredyExistException {
		List<InsuranceScheme> listOfInsuranceSchemes = getAllInsuranceScheme();
		Optional<InsuranceScheme> schemes = listOfInsuranceSchemes.stream().filter(e -> e.getInsuranceScheme().equals(insurenceScheme.getInsuranceScheme()))
				.findFirst();
		if (schemes.isPresent()) {
			throw new InsuranceSchemealredyExistException();
		}
		return insurenceSchemeRepository.save(insurenceScheme);
	}

	@Override
	public List<InsuranceScheme> getAllInsuranceScheme() {
		List<InsuranceScheme> listOfSchemes = insurenceSchemeRepository.findAll();
		return listOfSchemes;
	}

	@Override
	public InsuranceScheme getInsuranceSchemeById(long insurenceSchemeId) throws SchemeNotPresentException {
		Optional<InsuranceScheme> scheme = insurenceSchemeRepository.findById(insurenceSchemeId);
		if (!scheme.isPresent()) {
			throw new SchemeNotPresentException();
		}
			return scheme.get();
	}

	@Override
	public InsuranceScheme updateStatusOfInsuranceSchemeById(String status, long insurenceSchemeId) throws SchemeNotPresentException {
		InsuranceScheme scheme = getInsuranceSchemeById(insurenceSchemeId);
		scheme.setStatus(status);
		InsuranceScheme saveScheme = insurenceSchemeRepository.save(scheme);
		return saveScheme;
	}

}
