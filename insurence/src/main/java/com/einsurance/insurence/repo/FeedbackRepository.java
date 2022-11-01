package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
