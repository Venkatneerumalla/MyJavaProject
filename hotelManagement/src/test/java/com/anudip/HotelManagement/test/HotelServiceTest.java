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
import com.anudip.HotelManagement.entities.Hotel;
import com.anudip.HotelManagement.entities.Room;
import com.anudip.HotelManagement.service.HotelService;
import com.anudip.HotelManagement.service.RoomService;
import com.anudip.HotelManagement.serviceImpl.HotelServiceImpl;
import com.anudip.HotelManagement.serviceImpl.RoomServiceImpl;
import com.anudip.HotelManagement.utils.HibernateUtil;

class HotelServiceTest {

	static SessionFactory sessionFactory;
	static Session session;
	static HotelService hotelService;
	static RoomService roomService;
	
	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		hotelService = new HotelServiceImpl();
		roomService = new RoomServiceImpl();
	}
	
	 @Test
	    void testSaveFeedback() {
		 	Room room = roomService.getRoomById(1001);
		 	Hotel hotel = new Hotel('V',2,"VV Hotel","vk@gmail.com","Hyderabad",9988774455L);
	        assertTrue(hotelService.saveHotel(hotel));
	    }

	    @Test
	    void testGetAllFeedback() {
	        List<Hotel> hotels = hotelService.getAllHotels();
	        assertNotNull(hotels);
	        assertFalse(hotels.isEmpty());
	    }

	    @Test
	    void testGetHotelById() {
	        Hotel hotel = hotelService.getHotelById(2);
	        assertNotNull(hotel);
	        assertEquals(2L, hotel.getHotelId());
	    }

	    @Test
	    void testDeleteHotel() {
	        assertTrue(hotelService.deleteHotel(2));
	    }  

	    @AfterAll
	    static void tearDown() {
	        sessionFactory.close();
	    }

}
