package com.anudip.HotelManagement.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.anudip.HotelManagement.entities.Booking;
import com.anudip.HotelManagement.entities.Feedback;
import com.anudip.HotelManagement.service.BookingService;
import com.anudip.HotelManagement.service.FeedbackService;
import com.anudip.HotelManagement.serviceImpl.BookingServiceImpl;
import com.anudip.HotelManagement.serviceImpl.FeedbackServiceImpl;
import com.anudip.HotelManagement.utils.HibernateUtil;

class FeedbackServiceTest {

    static SessionFactory sessionFactory;
    static Session session;
    static FeedbackService feedbackService;
    static BookingService bookingService;

    @BeforeAll
    static void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
        feedbackService = new FeedbackServiceImpl();
        bookingService = new BookingServiceImpl();
    }

  /*  @Test
    void testSaveFeedback() {
    	Booking booking = bookingService.getBookingById(2L);
        Feedback feedback = new Feedback('S',1L,"Great experience!",5,booking);
        assertTrue(feedbackService.saveFeedback(feedback));
    }

    @Test
    void testGetAllFeedback() {
        List<Feedback> feedbacks = feedbackService.getAllFeedback();
        assertNotNull(feedbacks);
        assertFalse(feedbacks.isEmpty());
    }

    @Test
    void testGetFeedbackById() {
        Feedback feedback = feedbackService.getFeedbackById(1L);
        assertNotNull(feedback);
        assertEquals(1L, feedback.getFeedbackId());
    } */

    @Test
    void testDeleteFeedback() {
        assertTrue(feedbackService.deleteFeedback(1L));
    }

    @AfterAll
    static void tearDown() {
        sessionFactory.close();
    }
}
