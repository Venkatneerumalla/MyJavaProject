package com.anudip.HotelManagement.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anudip.HotelManagement.entities.Booking;
import com.anudip.HotelManagement.dao.BookingDAO;
import com.anudip.HotelManagement.service.BookingService;
import com.anudip.HotelManagement.serviceimpl.BookingServiceImpl;

public class BookingServiceImplTest {

    @Mock
    private BookingDAO bookingDAO;

    private BookingService bookingService;

    private Booking booking1;
    private Booking booking2;
    private List<Booking> bookings;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        bookingService = new BookingServiceImpl(bookingDAO);

        booking1 = new Booking();
        booking1.setBookingId(1L);
        booking2 = new Booking();
        booking2.setBookingId(2L);

        bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);
    }

    @Test
    public void testAddBooking() {
        bookingService.addBooking(booking1);
        verify(bookingDAO).addBooking(booking1);
    }

    @Test
    public void testGetBookingById() {
        when(bookingDAO.getBookingById(1L)).thenReturn(booking1);
        Booking retrievedBooking = bookingService.getBookingById(1L);
        assertNotNull(retrievedBooking);
        assertEquals(booking1, retrievedBooking);
    }

    @Test
    public void testGetAllBookings() {
        when(bookingDAO.getAllBookings()).thenReturn(bookings);
        List<Booking> retrievedBookings = bookingService.getAllBookings();
        assertNotNull(retrievedBookings);
        assertEquals(bookings.size(), retrievedBookings.size());
    }

    @Test
    public void testUpdateBooking() {
        bookingService.updateBooking(booking2);
        verify(bookingDAO).updateBooking(booking2);
    }

    @Test
    public void testDeleteBooking() {
        bookingService.deleteBooking(2L);
        verify(bookingDAO).deleteBooking(2L);
    }
}
