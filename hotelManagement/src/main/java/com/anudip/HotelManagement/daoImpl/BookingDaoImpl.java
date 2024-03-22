package com.anudip.HotelManagement.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.anudip.HotelManagement.dao.BookingDao;
import com.anudip.HotelManagement.entities.Booking;
import com.anudip.HotelManagement.utils.HibernateUtil;
import com.mysql.cj.Query;

public class BookingDaoImpl implements BookingDao {

	@Override
	public boolean saveBooking(Booking booking) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(booking);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return false;
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> bookings = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			bookings = session.createQuery("FROM Booking", Booking.class).getResultList();
			session.getTransaction().commit();
			System.out.println("Booking details retrieved successfully.");
			return bookings;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return bookings;
		
	}

	@Override
	public Booking getBookingById(int bookingId) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			Booking booking = session.get(Booking.class, bookingId);
			session.getTransaction().commit();
			return booking;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return null;
	}

	@Override
	public boolean deleteBooking(int bookingId) {
		try (Session session = HibernateUtil.getSession()) {

			Booking booking = session.get(Booking.class, bookingId);

			session.beginTransaction();
			if (booking != null) {
				booking.setRecord_status('I');
				session.saveOrUpdate(booking);
				session.getTransaction().commit();

				System.out.println("Booking deleted successfully.");

				return true;
			}
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);

		}
		
		return false;
	}

   
}
