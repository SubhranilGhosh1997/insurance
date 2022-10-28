package com.einsurance.insurence.exceptions;

import lombok.Getter;

public class StateAlreadyExistException extends Exception {

	private static final long serialVersionUID = 2475429455081969893L;
	
	@Getter
	private String errorMsg;

	public StateAlreadyExistException() {
		super();
		this.errorMsg = "State Already Added!!";
	}

}
