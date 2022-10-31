package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.UserNotValidException;
import com.einsurance.insurence.model.Agent;



public interface AgentService {
	Agent addAgent(Agent agent);

	List<Agent> getAgent();

	Agent login(String emailId, String password) throws UserNotValidException;

}
