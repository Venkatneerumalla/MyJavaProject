package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Booking;

public interface BookingService {

    public boolean saveBooking(Booking booking);

    public List<Booking> getAllBookings();

    public Booking getBookingById(Long bookingId);

    public boolean deleteBooking(Long bookingId);
}
