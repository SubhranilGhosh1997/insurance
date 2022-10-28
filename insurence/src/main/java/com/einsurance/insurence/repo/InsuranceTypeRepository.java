package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.InsuranceType;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Long>{

	InsuranceType findByInsuranceType(String insuranceType);
}
