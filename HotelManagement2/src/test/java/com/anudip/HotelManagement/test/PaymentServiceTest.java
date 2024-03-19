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
import com.anudip.HotelManagement.entities.Payment;
import com.anudip.HotelManagement.service.BookingService;
import com.anudip.HotelManagement.service.FeedbackService;
import com.anudip.HotelManagement.service.PaymentService;
import com.anudip.HotelManagement.serviceImpl.BookingServiceImpl;
import com.anudip.HotelManagement.serviceImpl.FeedbackServiceImpl;
import com.anudip.HotelManagement.serviceImpl.PaymentServiceImpl;
import com.anudip.HotelManagement.utils.HibernateUtil;

class PaymentServiceTest {

	 static SessionFactory sessionFactory;
	    static Session session;
	    static PaymentService paymentService;;
	    static BookingService bookingService;

	    @BeforeAll
	    static void setUp() {
	        sessionFactory = HibernateUtil.getSessionFactory();
	        paymentService = new PaymentServiceImpl();
	        bookingService = new BookingServiceImpl();
	    }

	/*    @Test
	    void testSavePayment() {
	    	Booking booking = bookingService.getBookingById(2L);
	        Payment payment = new Payment('S',1L,booking,1500.00,"Online","2024/03/17");
	        assertTrue(paymentService.savePayment(payment));
	    }*/

	    @Test
	    void testGetAllPayment() {
	        List<Payment> payments = paymentService.getAllPayments();
	        assertNotNull(payments);
	        assertFalse(payments.isEmpty());
	    }

	/*    @Test
	    void testGetPaymnetById() {
	        Payment payment = paymentService.getPaymentById(1L);
	        assertNotNull(payment);
	        assertEquals(1L, payment.getPaymentId());
	    }

	    @Test
	    void testDeletePayment() {
	        assertTrue(paymentService.deletePayment(1L));
	    }*/

	    @AfterAll
	    static void tearDown() {
	        sessionFactory.close();
	    }

}
