package com.anudip.HotelManagement.dao;

import com.anudip.HotelManagement.entities.Feedback;
import java.util.List;

public interface FeedbackDAO {

    void addFeedback(Feedback feedback);

    Feedback getFeedbackById(Long feedbackId);

    List<Feedback> getAllFeedbacks();

    void updateFeedback(Feedback feedback);

    void deleteFeedback(Long feedbackId);
}
