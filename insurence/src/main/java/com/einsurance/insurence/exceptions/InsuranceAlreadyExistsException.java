package com.einsurance.insurence.exceptions;

public class InsuranceAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -7397204944671635781L;

	private String errorMsg;
	public InsuranceAlreadyExistsException() {
		errorMsg="Insurence Plan already Exists !!";
	}
	public String getErrorMsg() {
		return errorMsg;
	}
}
