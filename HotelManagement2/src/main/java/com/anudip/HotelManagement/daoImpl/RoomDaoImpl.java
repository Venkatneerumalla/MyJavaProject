package com.anudip.HotelManagement.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.anudip.HotelManagement.dao.RoomDao;
import com.anudip.HotelManagement.entities.Hotel;
import com.anudip.HotelManagement.entities.Room;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class RoomDaoImpl implements RoomDao {

	@Override
	public boolean saveRoom(Room room) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(room);
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
	public List<Room> getAllRooms() {
		try (Session session = HibernateUtil.getSession()) {
			List<Room> rooms = session.createQuery("from Room", Room.class).getResultList();
			System.out.println("Room details retrieved successfully.");
			return rooms;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Room getRoomById(Long roomId) {
		try (Session session = HibernateUtil.getSession()) {
			Room room = session.get(Room.class, roomId);
			return room;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	@Override
	public boolean deleteRoom(Long roomId) {
		try (Session session = HibernateUtil.getSession()) {
			Room room = session.get(Room.class, roomId);

			session.beginTransaction();
			if (room != null) {
				room.setRecord_status('I');
				session.saveOrUpdate(room);
				session.getTransaction().commit();
				System.out.println("Room deleted successfully.");
				return true;
			} else {
				System.out.println("Room details not found");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

	@Override
	public List<Room> getRoomsByHotel(Long hotelId) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();

			String hqlQuery = "Select * from Room where room_id = :roomId";

			List<Room> rooms = session.createNativeQuery(hqlQuery, Room.class)
					.setParameter("hotelId", hotelId).getResultList();

			transaction.commit();
			return rooms;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

   
}
