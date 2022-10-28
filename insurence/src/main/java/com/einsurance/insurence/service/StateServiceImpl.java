package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.StateAlreadyExistException;
import com.einsurance.insurence.exceptions.StateNotPresentException;
import com.einsurance.insurence.model.State;
import com.einsurance.insurence.repo.StateRepository;
@Service
public class StateServiceImpl implements StateService {
	@Autowired
	StateRepository stateRepository;
	
	@Override
	public State addState(State state) throws StateAlreadyExistException {
		List<State> states = getStates();
		Optional<State> stateOptional = states.stream().filter(e-> e.getState().equals(state.getState())).findAny();
		if(stateOptional.isPresent()) {
			throw new StateAlreadyExistException();
		}
		return stateRepository.save(state);
	}

	@Override
	public State updateStatus(String status,long stateId) throws StateNotPresentException {
		State state = getStateById(stateId);
		state.setStatus(status);
		stateRepository.save(state);
		return state;
	}

	@Override
	public List<State> getStates() {
		List<State> states = stateRepository.findAll();
		return states;
	}

	@Override
	public State getStateById(long stateId) throws StateNotPresentException {
		Optional<State> stateOptional = stateRepository.findById(stateId);
		if(!stateOptional.isPresent())
		{
			throw new StateNotPresentException();
		}
		return stateOptional.get();
	}

	@Override
	public void deleteState(long stateId) throws StateNotPresentException {
		State state = getStateById(stateId);
		stateRepository.delete(state);
		
	}

}
