package com.anudip.HotelManagement.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.anudip.HotelManagement.dao.FeedbackDAO;
import com.anudip.HotelManagement.entities.Feedback;
import com.anudip.HotelManagement.serviceimpl.FeedbackServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackServiceImplTest {

    @Mock
    private FeedbackDAO feedbackDAO;

    @InjectMocks
    private FeedbackServiceImpl feedbackServiceImpl;

    @Test
    public void testAddFeedback() {
        Feedback feedback = new Feedback();
        feedback.setComment("Test Feedback");
        feedbackServiceImpl.addFeedback(feedback);
        verify(feedbackDAO, times(1)).addFeedback(feedback);
    }

    @Test
    public void testGetFeedbackById() {
        Long feedbackId = 1L;
        Feedback mockFeedback = new Feedback();
        mockFeedback.setFeedbackId(feedbackId);
        mockFeedback.setComment("Retrieved Feedback");
        when(feedbackDAO.getFeedbackById(feedbackId)).thenReturn(mockFeedback);
        Feedback retrievedFeedback = feedbackServiceImpl.getFeedbackById(feedbackId);
        assertEquals(mockFeedback, retrievedFeedback);
    }

    @Test
    public void testGetAllFeedbacks() {
        List<Feedback> mockFeedbacks = new ArrayList<>();
        mockFeedbacks.add(new Feedback());
        mockFeedbacks.add(new Feedback());
        when(feedbackDAO.getAllFeedbacks()).thenReturn(mockFeedbacks);
        List<Feedback> retrievedFeedbacks = feedbackServiceImpl.getAllFeedbacks();
        assertEquals(mockFeedbacks, retrievedFeedbacks);
    }

    @Test
    public void testUpdateFeedback() {
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(2L);
        feedbackServiceImpl.updateFeedback(feedback);
        verify(feedbackDAO, times(1)).updateFeedback(feedback);
    }

    @Test
    public void testDeleteFeedback() {
        Long feedbackId = 3L;
        feedbackServiceImpl.deleteFeedback(feedbackId);
        verify(feedbackDAO, times(1)).deleteFeedback(feedbackId);
    }
}

