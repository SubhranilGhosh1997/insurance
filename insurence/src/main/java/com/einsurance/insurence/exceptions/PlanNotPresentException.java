package com.einsurance.insurence.exceptions;

public class PlanNotPresentException extends Exception {

	private static final long serialVersionUID = 5223567136182633841L;

	private String errorMsg;

	public PlanNotPresentException() {
		errorMsg = "Insurence Plan does not exist !!";
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}
