package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.FeedbackNotFoundException;
import com.einsurance.insurence.model.Feedback;
import com.einsurance.insurence.repo.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public Feedback addFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	@Override
	public List<Feedback> getFeedbacks() {
		List<Feedback> feedbacks = feedbackRepository.findAll();
		return feedbacks;
	}

	@Override
	public Feedback giveFeedBackById(long feedbackId, String reply) throws FeedbackNotFoundException {
		Optional<Feedback> feedbackOptional = feedbackRepository.findById(feedbackId);
		if(!feedbackOptional.isPresent()) {
			throw new FeedbackNotFoundException();
		}
		Feedback feedback = feedbackOptional.get();
		feedback.setReply(reply);
		feedbackRepository.save(feedback);
		return feedback;
	}

}
