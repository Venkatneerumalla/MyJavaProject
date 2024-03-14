package com.anudip.HotelManagement.serviceimpl;

import java.util.List;

import org.hibernate.Session;

import com.anudip.HotelManagement.dao.RoomDAO;
import com.anudip.HotelManagement.entities.Room;
import com.anudip.HotelManagement.service.RoomService;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO;

    public RoomServiceImpl(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public void addRoom(Room room) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            roomDAO.addRoom(room);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Room getRoomById(Long roomId) {
        try (Session session = HibernateUtil.getSession()) {
            return roomDAO.getRoomById(roomId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Room> getAllRooms() {
        try (Session session = HibernateUtil.getSession()) {
            return roomDAO.getAllRooms();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateRoom(Room room) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            roomDAO.updateRoom(room);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(Long roomId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            roomDAO.deleteRoom(roomId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
