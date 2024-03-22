package com.anudip.HotelManagement.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.anudip.HotelManagement.entities.Booking;
import com.anudip.HotelManagement.entities.Customer;
import com.anudip.HotelManagement.entities.Room;
import com.anudip.HotelManagement.service.BookingService;
import com.anudip.HotelManagement.service.CustomerService;
import com.anudip.HotelManagement.service.RoomService;
import com.anudip.HotelManagement.serviceImpl.BookingServiceImpl;
import com.anudip.HotelManagement.serviceImpl.CustomerServiceImpl;
import com.anudip.HotelManagement.serviceImpl.RoomServiceImpl;
import com.anudip.HotelManagement.utils.HibernateUtil;

class BookingServiceTest {

	static SessionFactory sessionFactory;
	static Session session;
	static BookingService bookingService;
	static RoomService roomService;
	static CustomerService customerService;
	
	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		bookingService = new BookingServiceImpl();
		roomService = new RoomServiceImpl();
		customerService = new CustomerServiceImpl();
	}
	
	  @Test
	    void testSaveBooking() {
		  Room room = roomService.getRoomById(1);
		  Customer customer = customerService.getCustomerById(1);
	      Booking booking = new Booking('A',1,room,customer,"2024-03-17","2024-03-18");
	        
	        assertTrue(bookingService.saveBooking(booking));
	    }

	    @Test
	    void testGetAllBookings() {
	        List<Booking> bookings = bookingService.getAllBookings();
	        assertNotNull(bookings);
	        assertFalse(bookings.isEmpty());
	    }

	    @Test
	    void testGetBookingById() {
	        Booking booking = bookingService.getBookingById(1);
	        assertNotNull(booking);
	        assertEquals(1, booking.getBookingId());
	    }

	    @Test
	    void testDeleteBooking() {
	    	boolean booking = bookingService.deleteBooking(1);
	        assertTrue(booking);
	    }
	    
	    @AfterAll
		static void tearDown() {
			sessionFactory.close();
		}
}
