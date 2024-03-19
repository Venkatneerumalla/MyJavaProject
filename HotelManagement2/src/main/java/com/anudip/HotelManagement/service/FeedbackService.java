package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Feedback;

public interface FeedbackService {

    public boolean saveFeedback(Feedback feedback);

    public List<Feedback> getAllFeedback();

    public Feedback getFeedbackById(Long feedbackId);

    public boolean deleteFeedback(Long feedbackId);

}
