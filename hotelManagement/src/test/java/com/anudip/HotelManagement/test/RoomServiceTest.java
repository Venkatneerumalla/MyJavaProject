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
import com.anudip.HotelManagement.service.BookingService;
import com.anudip.HotelManagement.service.FeedbackService;
import com.anudip.HotelManagement.service.HotelService;
import com.anudip.HotelManagement.service.RoomService;
import com.anudip.HotelManagement.serviceImpl.BookingServiceImpl;
import com.anudip.HotelManagement.serviceImpl.FeedbackServiceImpl;
import com.anudip.HotelManagement.serviceImpl.HotelServiceImpl;
import com.anudip.HotelManagement.serviceImpl.RoomServiceImpl;
import com.anudip.HotelManagement.utils.HibernateUtil;

class RoomServiceTest {

	 	static SessionFactory sessionFactory;
	    static Session session;
	    static RoomService roomService;
	    static HotelService hotelService;

	    @BeforeAll
	    static void setUp() {
	        sessionFactory = HibernateUtil.getSessionFactory();
	        roomService = new RoomServiceImpl();
	        hotelService = new HotelServiceImpl();
	    }

	/*    @Test
	    void testSaveFeedback() {
	    	Hotel hotel = hotelService.getHotelById(1);
	        Room room = new Room('S',1,1500.00,5,"Double",hotel);
	        assertTrue(roomService.saveRoom(room));
	    }

	   @Test
	    void testGetAllRoom() {
	        List<Room> rooms = roomService.getAllRooms();
	        assertNotNull(rooms);
	        assertTrue(rooms.isEmpty());
	    }

	    @Test
	    void testGetRoomById() {
	        Room room = roomService.getRoomById(1);
	        assertNotNull(room);
	        assertEquals(1, room.getRoomId());
	    } */

	    @Test
	    void testDeleteRoom() {
	        assertFalse(roomService.deleteRoom(1));
	    } 

	    @AfterAll
	    static void tearDown() {
	        sessionFactory.close();
	    }

}
