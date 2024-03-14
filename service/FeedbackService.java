package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Feedback;

public interface FeedbackService {

    public void addFeedback(Feedback feedback);

    public Feedback getFeedbackById(Long feedbackId);

    public List<Feedback> getAllFeedbacks();

    public void updateFeedback(Feedback feedback);

    public void deleteFeedback(Long feedbackId);
}
