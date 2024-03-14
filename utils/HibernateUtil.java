package com.anudip.HotelManagement.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anudip.HotelManagement.entities.Booking;
import com.anudip.HotelManagement.entities.Customer;
import com.anudip.HotelManagement.entities.Feedback;
import com.anudip.HotelManagement.entities.Hotel;
import com.anudip.HotelManagement.entities.Payment;
import com.anudip.HotelManagement.entities.Room;

public class HibernateUtil {

	private final static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			return new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hotel.class)
					.addAnnotatedClass(Room.class)
					.addAnnotatedClass(Booking.class)
					.addAnnotatedClass(Customer.class)
					.addAnnotatedClass(Feedback.class)
					.addAnnotatedClass(Payment.class)
.buildSessionFactory();

		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession(); // session opened
	}

}