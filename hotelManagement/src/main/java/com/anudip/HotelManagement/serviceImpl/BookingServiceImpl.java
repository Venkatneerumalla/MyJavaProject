package com.anudip.HotelManagement.serviceImpl;

import java.util.List;

import com.anudip.HotelManagement.dao.BookingDao;
import com.anudip.HotelManagement.daoImpl.BookingDaoImpl;
import com.anudip.HotelManagement.entities.Booking;
import com.anudip.HotelManagement.service.BookingService;

public class BookingServiceImpl implements BookingService{
	
	BookingDao bookindDao = new BookingDaoImpl();

	@Override
	public boolean saveBooking(Booking booking) {
		return bookindDao.saveBooking(booking);
	}

	@Override
	public List<Booking> getAllBookings() {
		
		return bookindDao.getAllBookings();
	}

	@Override
	public Booking getBookingById(int bookingId) {
		
		return bookindDao.getBookingById(bookingId);
	}

	@Override
	public boolean deleteBooking(int bookingId) {
		
		return bookindDao.deleteBooking(bookingId);
	}

}
