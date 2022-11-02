package com.einsurance.insurence.service;

import java.util.Optional;

import com.einsurance.insurence.model.InsuranceSettings;

public interface InsuranceSettingsService {
	
	InsuranceSettings updateSetting(InsuranceSettings insuranceSettings);
	Optional<InsuranceSettings> GetSetting();
	InsuranceSettings updateTax(InsuranceSettings insuranceSettings);
	InsuranceSettings getSettingById(long i);
}
