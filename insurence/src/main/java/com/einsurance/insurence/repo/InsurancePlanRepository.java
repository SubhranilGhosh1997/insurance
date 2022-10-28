package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.InsurancePlan;

public interface InsurancePlanRepository extends JpaRepository<InsurancePlan, Long>{

}
