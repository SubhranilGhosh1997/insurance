package com.einsurance.insurence.exceptions;

public class InsuranceTypeNotPresentException extends Exception {

	private static final long serialVersionUID = -3930686362183302054L;
	
	private String errorMsg;

	public InsuranceTypeNotPresentException() {
		errorMsg = "Insurence Type not Present";
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
