package com.einsurance.insurence.exceptions;

import lombok.Getter;

public class CityNotPresentException extends Exception {

	private static final long serialVersionUID = -3407535003847378045L;
	@Getter
	private String errorMsg;

	public CityNotPresentException() {
		super();
		this.errorMsg = "City Not Present";
	}

}
