package com.einsurance.insurence.exceptions;

public class SchemeNotPresentException extends Exception {

	private static final long serialVersionUID = 7298853389546060454L;
	private String errorMsg;

	public SchemeNotPresentException() {
		errorMsg = "Insurence Scheme not Present";
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}
