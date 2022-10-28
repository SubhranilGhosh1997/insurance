package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.InsurenceSchemealredyExistException;
import com.einsurance.insurence.exceptions.SchemeNotPresentException;
import com.einsurance.insurence.model.InsurenceScheme;
import com.einsurance.insurence.repo.InsurenceSchemeRepository;

@Service
public class InsurenceSchemeServiceImpl implements InsurenceSchemeService {

	@Autowired
	InsurenceSchemeRepository insurenceSchemeRepository;

	@Override
	public InsurenceScheme addInsuranceScheme(InsurenceScheme insurenceScheme) throws InsurenceSchemealredyExistException {
		List<InsurenceScheme> listOfInsuranceSchemes = getAllInsuranceScheme();
		Optional<InsurenceScheme> schemes = listOfInsuranceSchemes.stream().filter(e -> e.getInsuranceScheme().equals(insurenceScheme.getInsuranceScheme()))
				.findFirst();
		if (schemes.isPresent()) {
			throw new InsurenceSchemealredyExistException();
		}
		return insurenceSchemeRepository.save(insurenceScheme);
	}

	@Override
	public List<InsurenceScheme> getAllInsuranceScheme() {
		List<InsurenceScheme> listOfSchemes = insurenceSchemeRepository.findAll();
		return listOfSchemes;
	}

	@Override
	public InsurenceScheme getInsuranceSchemeById(long insurenceSchemeId) throws SchemeNotPresentException {
		Optional<InsurenceScheme> scheme = insurenceSchemeRepository.findById(insurenceSchemeId);
		if (!scheme.isPresent()) {
			throw new SchemeNotPresentException();
		}
			return scheme.get();
	}

	@Override
	public InsurenceScheme updateStatusOfInsuranceSchemeById(String status, long insurenceSchemeId) throws SchemeNotPresentException {
		InsurenceScheme scheme = getInsuranceSchemeById(insurenceSchemeId);
		scheme.setStatus(status);
		InsurenceScheme saveScheme = insurenceSchemeRepository.save(scheme);
		return saveScheme;
	}

}
