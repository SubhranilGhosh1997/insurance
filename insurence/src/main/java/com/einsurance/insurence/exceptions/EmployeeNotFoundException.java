package com.einsurance.insurence.exceptions;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = -5744571064727973253L;
	private String errorMsg;
	public EmployeeNotFoundException() {
		errorMsg="Employee not Found";
	}
	public String getErrorMsg() {
		return errorMsg;
	}
}
