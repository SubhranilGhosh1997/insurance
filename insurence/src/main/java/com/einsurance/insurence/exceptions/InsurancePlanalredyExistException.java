package com.einsurance.insurence.exceptions;

public class InsurancePlanalredyExistException extends Exception {

	private static final long serialVersionUID = -1011461754643091881L;

	private String errorMsg;
	public InsurancePlanalredyExistException() {
		errorMsg="Insurence Plan already Exists !!";
	}
	public String getErrorMsg() {
		return errorMsg;
	}
}
