package com.anudip.HotelManagement.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.anudip.HotelManagement.dao.HotelDAO;
import com.anudip.HotelManagement.entities.Hotel;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class HotelDAOImpl implements HotelDAO {

    @Override
    public void addHotel(Hotel hotel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(hotel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void updateHotel(Hotel hotel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.update(hotel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHotel(Long hotelId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Hotel hotel = session.get(Hotel.class, hotelId);
            if (hotel != null) {
                session.delete(hotel);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Hotel> getAllHotels() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from Hotel").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public Hotel getHotelById(Long hotelId) {
		try (Session session = HibernateUtil.getSession()) {
            return session.get(Hotel.class, hotelId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	
}
