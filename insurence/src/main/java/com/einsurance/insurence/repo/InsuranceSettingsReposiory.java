package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.InsuranceSettings;

public interface InsuranceSettingsReposiory extends JpaRepository<InsuranceSettings,Long> {

}
