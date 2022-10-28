package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.InsurenceScheme;

public interface InsurenceSchemeRepository extends JpaRepository<InsurenceScheme,Long> {

}
