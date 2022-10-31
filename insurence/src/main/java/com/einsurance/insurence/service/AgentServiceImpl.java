package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.UserNotValidException;
import com.einsurance.insurence.model.Agent;
import com.einsurance.insurence.repo.AgentRepository;


@Service
public class AgentServiceImpl implements AgentService {
	@Autowired
	AgentRepository agentRepository;
	@Override
	public Agent addAgent(Agent agent) {
		agent.setRole("ROLE_Agent");
		Agent savedAgent = agentRepository.save(agent);
		
		return savedAgent;
	}
	@Override
	public List<Agent> getAgent() {
		List<Agent> agentList = agentRepository.findAll();
		return agentList;
	}
	@Override
	public Agent login(String emailId, String password) throws UserNotValidException {
		Optional<Agent> agentsOptional=agentRepository.findAllByEmailIdAndPassword(emailId, password);
		if(!agentsOptional.isPresent())
		{
			throw new UserNotValidException("Username & Password invalid"); 
		}
		return	agentsOptional.get();
	}

}
