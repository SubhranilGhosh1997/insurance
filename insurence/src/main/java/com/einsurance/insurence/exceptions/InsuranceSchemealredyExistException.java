package com.einsurance.insurence.exceptions;

public class InsuranceSchemealredyExistException extends Exception {

	private static final long serialVersionUID = 7215887557727580443L;
	private String errorMsg;

	public InsuranceSchemealredyExistException() {
		errorMsg = "Insurence Scheme already Exists !!";
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}
