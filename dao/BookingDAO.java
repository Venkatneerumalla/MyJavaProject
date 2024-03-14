package com.anudip.HotelManagement.dao;

import com.anudip.HotelManagement.entities.Booking;
import java.util.List;

public interface BookingDAO {

    void addBooking(Booking booking);

    Booking getBookingById(Long bookingId);

    List<Booking> getAllBookings();

    void updateBooking(Booking booking);

    void deleteBooking(Long bookingId);
}
