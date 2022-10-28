package com.einsurance.insurence.exceptions;

import lombok.Getter;

public class StateNotPresentException extends Exception {

	private static final long serialVersionUID = 6430705495737302169L;
	@Getter
	private String errorMsg;

	public StateNotPresentException() {
		super();
		this.errorMsg = "State Not Present";
	}
}
