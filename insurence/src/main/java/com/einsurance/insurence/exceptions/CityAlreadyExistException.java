package com.einsurance.insurence.exceptions;

import lombok.Getter;

public class CityAlreadyExistException extends Exception {

	private static final long serialVersionUID = -5699117589701264708L;
	@Getter
	private String errorMsg;

	public CityAlreadyExistException() {
		super();
		this.errorMsg = "City Already Added!!";
	}
}
