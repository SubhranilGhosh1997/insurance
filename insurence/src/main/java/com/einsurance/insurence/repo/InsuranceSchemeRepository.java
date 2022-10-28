package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.InsurenceScheme;

public interface InsuranceSchemeRepository extends JpaRepository<InsurenceScheme,Long> {

}
