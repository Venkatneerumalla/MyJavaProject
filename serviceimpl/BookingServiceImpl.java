package com.anudip.HotelManagement.serviceimpl;

import java.util.List;

import org.hibernate.Session;

import com.anudip.HotelManagement.dao.BookingDAO;
import com.anudip.HotelManagement.entities.Booking;
import com.anudip.HotelManagement.service.BookingService;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class BookingServiceImpl implements BookingService {

    private BookingDAO bookingDAO;

    public BookingServiceImpl(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public void addBooking(Booking booking) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            bookingDAO.addBooking(booking);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        try (Session session = HibernateUtil.getSession()) {
            return bookingDAO.getBookingById(bookingId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Booking> getAllBookings() {
        try (Session session = HibernateUtil.getSession()) {
            return bookingDAO.getAllBookings();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateBooking(Booking booking) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            bookingDAO.updateBooking(booking);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBooking(Long bookingId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            bookingDAO.deleteBooking(bookingId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
