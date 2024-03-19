package com.anudip.HotelManagement.dao;

import java.util.List;

import com.anudip.HotelManagement.entities.Booking;
import com.anudip.HotelManagement.entities.Feedback;

public interface FeedbackDao {

    public boolean saveFeedback(Feedback feedback);

    public List<Feedback> getAllFeedback();

    public Feedback getFeedbackById(Long feedbackId);

    public boolean deleteFeedback(Long feedbackId);

}
