package com.anudip.HotelManagement.serviceimpl;

import java.util.List;

import org.hibernate.Session;

import com.anudip.HotelManagement.dao.HotelDAO;
import com.anudip.HotelManagement.entities.Hotel;
import com.anudip.HotelManagement.service.HotelService;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class HotelServiceImpl implements HotelService {

    private HotelDAO hotelDAO;

    public HotelServiceImpl(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    @Override
    public void addHotel(Hotel hotel) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            hotelDAO.addHotel(hotel);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hotel getHotelById(Long hotelId) {
        try (Session session = HibernateUtil.getSession()) {
            return hotelDAO.getHotelById(hotelId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Hotel> getAllHotels() {
        try (Session session = HibernateUtil.getSession()) {
            return hotelDAO.getAllHotels();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateHotel(Hotel hotel) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            hotelDAO.updateHotel(hotel);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHotel(Long hotelId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            hotelDAO.deleteHotel(hotelId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
