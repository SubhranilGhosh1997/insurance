package com.einsurance.insurence.exceptions;

import lombok.Getter;

public class UserNotValidException extends Exception{
	
	private static final long serialVersionUID = 1147708286436428321L;
	@Getter
	private String errorMsg;

	public UserNotValidException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
	
}
