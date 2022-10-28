package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.InsuranceScheme;

public interface InsuranceSchemeRepository extends JpaRepository<InsuranceScheme,Long> {

}
