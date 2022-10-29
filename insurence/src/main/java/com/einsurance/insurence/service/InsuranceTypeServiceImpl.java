package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.InsuranceAlreadyExistsException;
import com.einsurance.insurence.exceptions.InsuranceTypeNotPresentException;
import com.einsurance.insurence.model.InsuranceType;
import com.einsurance.insurence.repo.InsuranceTypeRepository;
@Service
public class InsuranceTypeServiceImpl implements InsuranceTypeService {
	
	@Autowired
	InsuranceTypeRepository insuranceTypeRepository;
	@Override
	public InsuranceType addInsuranceType(InsuranceType insuranceType) throws InsuranceAlreadyExistsException {
		
		InsuranceType findByInsuranceType = insuranceTypeRepository.findByInsuranceType(insuranceType.getInsuranceType());
		if(findByInsuranceType!=null) {
			throw new InsuranceAlreadyExistsException();
		}
		InsuranceType savedInsuranceType = insuranceTypeRepository.save(insuranceType);
		return savedInsuranceType;
	}
	@Override
	public List<InsuranceType> getAllInsuranceTypes() {
		List<InsuranceType> listOfInsuranceTypes = insuranceTypeRepository.findAll();
		return listOfInsuranceTypes;
	}
	@Override
	public InsuranceType updateInsuranceType(InsuranceType insuranceType) throws InsuranceTypeNotPresentException {
		InsuranceType type = getInsuranceTypeById(insuranceType.getInsuranceTypeId());
		if (type ==null) {
			throw new InsuranceTypeNotPresentException();
		}
		InsuranceType saveInsuranceType = insuranceTypeRepository.save(insuranceType);
		return saveInsuranceType;
	}
	@Override
	public InsuranceType getInsuranceTypeById(long insuranceTypeId) throws InsuranceTypeNotPresentException {
		Optional<InsuranceType> optionalType = insuranceTypeRepository.findById(insuranceTypeId);
		if (!optionalType.isPresent()) {
			throw new InsuranceTypeNotPresentException();
		}
			return optionalType.get();
	}
	
}
