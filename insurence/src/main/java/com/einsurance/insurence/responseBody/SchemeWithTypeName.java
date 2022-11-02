package com.einsurance.insurence.responseBody;

import com.einsurance.insurence.model.InsuranceScheme;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class SchemeWithTypeName {
	InsuranceScheme insuranceScheme;
	String insuranceType;
}
