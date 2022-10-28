package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.Documents;

public interface DocumentRepository extends JpaRepository<Documents	, Long> {
    

}
