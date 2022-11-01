package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.FeedbackNotFoundException;
import com.einsurance.insurence.model.Feedback;

public interface FeedbackService {
	Feedback addFeedback(Feedback feedback);

	List<Feedback> getFeedbacks();
	
	Feedback giveFeedBackById(long feedbackId ,String reply) throws FeedbackNotFoundException;

	
	}
