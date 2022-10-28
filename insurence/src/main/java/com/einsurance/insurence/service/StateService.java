package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.StateAlreadyExistException;
import com.einsurance.insurence.exceptions.StateNotPresentException;
import com.einsurance.insurence.model.State;

public interface StateService {
	State addState(State state) throws StateAlreadyExistException;
	
	State updateStatus(String status, long stateId) throws StateNotPresentException;
	
	State getStateById(long stateId) throws StateNotPresentException;
	
	List<State> getStates();

	void deleteState(long stateId) throws StateNotPresentException;
	
}
