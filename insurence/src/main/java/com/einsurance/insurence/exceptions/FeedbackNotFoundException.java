package com.einsurance.insurence.exceptions;

public class FeedbackNotFoundException extends Exception {

	private static final long serialVersionUID = 4569999626280333238L;
	
	private String errorMsg;
	public FeedbackNotFoundException() {
		errorMsg="Feedback not present  !!";
	}
	public String getErrorMsg() {
		return errorMsg;
	}

}
