package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.State;

public interface StateRepository extends JpaRepository<State, Long>{

}