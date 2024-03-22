package com.anudip.HotelManagement.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.anudip.HotelManagement.dao.HotelDao;
import com.anudip.HotelManagement.entities.Hotel;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class HotelDaoImpl implements HotelDao {

	@Override
	public boolean saveHotel(Hotel hotel) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(hotel);
			session.getTransaction().commit();
			// commit
			session.close();
			return true;

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

	@Override
	public List<Hotel> getAllHotels() {
		try (Session session = HibernateUtil.getSession()) {
			List<Hotel> doctors = session.createQuery("from Hotel", Hotel.class).getResultList();
			System.out.println("Hotel details retrieved successfully.");
			return doctors;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Hotel getHotelById(int hotelId) {
		try (Session session = HibernateUtil.getSession()) {
			Hotel hotel = session.get(Hotel.class, hotelId);
			return hotel;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		try (Session session = HibernateUtil.getSession()) {
			Hotel hotel = session.get(Hotel.class, hotelId);

			session.beginTransaction();
			if (hotel != null) {
				hotel.setRecord_status('I');
				session.saveOrUpdate(hotel);
				session.getTransaction().commit();
				System.out.println("Hotel deleted successfully.");
				return true;
			} else {
				System.out.println("Hotel details not found");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

    
}
