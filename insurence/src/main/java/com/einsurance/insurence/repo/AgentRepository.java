package com.einsurance.insurence.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.Agent;


public interface AgentRepository extends JpaRepository<Agent,Long> {

	Optional<Agent> findAllByEmailIdAndPassword(String emailId, String password);

//    User findByEmail(String email);

}
