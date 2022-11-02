package com.einsurance.insurence.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

		InsuranceType findByInsuranceType = insuranceTypeRepository
				.findByInsuranceType(insuranceType.getInsuranceType());
		if (findByInsuranceType != null) {
			throw new InsuranceAlreadyExistsException();
		}

		InsuranceType newsavedInsuranceType = insuranceTypeRepository.save(insuranceType);
		return newsavedInsuranceType;

	}

	@Override
	public List<InsuranceType> getAllInsuranceTypes() {
		List<InsuranceType> listOfInsuranceTypes = insuranceTypeRepository.findAll();
		return listOfInsuranceTypes;
	}

	@Override
	public InsuranceType updateInsuranceType(InsuranceType insuranceType) throws InsuranceTypeNotPresentException {
		InsuranceType type = getInsuranceTypeById(insuranceType.getInsuranceTypeId());
		if (type == null) {
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

	@Override
	public String addInsuranceTypeImage(long insuranceTypeId, MultipartFile file, String path) throws InsuranceTypeNotPresentException {

		Optional<InsuranceType> InsuranceTypeoptional = insuranceTypeRepository.findById(insuranceTypeId);
		if (!InsuranceTypeoptional.isPresent()) {
			throw new InsuranceTypeNotPresentException();
		} else {
			try {
				InsuranceType insuranceType = InsuranceTypeoptional.get();
				insuranceType.setImageSrc(insuranceTypeId + file.getOriginalFilename());
//				String saveFile = new ClassPathResource("satic/image/").getFile();
				Path path1 = Paths.get(
						path + File.separator +insuranceTypeId+ file.getOriginalFilename());
				Files.copy(file.getInputStream(), path1);
				System.out.println("imageUploaded");
				insuranceTypeRepository.save(insuranceType);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
