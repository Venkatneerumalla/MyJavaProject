package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Booking;

public interface BookingService {

    public void addBooking(Booking booking);

    public Booking getBookingById(Long bookingId);

    public List<Booking> getAllBookings();

    public void updateBooking(Booking booking);

    public void deleteBooking(Long bookingId);
}
