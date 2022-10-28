package com.einsurance.insurence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.InsuranceAlreadyExistsException;
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
	
}
