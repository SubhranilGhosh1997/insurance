package com.einsurance.insurence.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.model.InsuranceSettings;
import com.einsurance.insurence.repo.InsuranceSettingsReposiory;

@Service
public class InsuranceSettingsServiceImpl implements InsuranceSettingsService {

	@Autowired
	InsuranceSettingsReposiory insuranceSettingsReposiory;

	@Override
	public InsuranceSettings updateSetting(InsuranceSettings insuranceSettings) {
		insuranceSettings.setInsuranceSettingId(1);
		Optional<InsuranceSettings> setting = GetSetting();
		if (GetSetting().isPresent()) {
			InsuranceSettings oldSetting = setting.get();
			insuranceSettings.setTaxPercentage(oldSetting.getTaxPercentage());
		}
		return insuranceSettingsReposiory.save(insuranceSettings);

	}
	@Override
	public InsuranceSettings updateTax(InsuranceSettings insuranceSettings) {
		insuranceSettings.setInsuranceSettingId(1);
		Optional<InsuranceSettings> setting = GetSetting();
		if (GetSetting().isPresent()) {
			InsuranceSettings oldSetting = setting.get();
			insuranceSettings.setClaimDeductionPercentage(oldSetting.getClaimDeductionPercentage());
			insuranceSettings.setPenaltyAmountPercentage(oldSetting.getPenaltyAmountPercentage());
		}
		return insuranceSettingsReposiory.save(insuranceSettings);

	}

	@Override
	public Optional<InsuranceSettings> GetSetting() {
		Optional<InsuranceSettings> insurenceSetting = insuranceSettingsReposiory.findById((long) 1);
		return insurenceSetting;
	}
	@Override
	public InsuranceSettings getSettingById(long i) {
		Optional<InsuranceSettings> insurenceSetting = insuranceSettingsReposiory.findById(i);
		return insurenceSetting.get();
	}

}
