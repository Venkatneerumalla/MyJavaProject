package com.anudip.HotelManagement.serviceImpl;

import java.util.List;

import com.anudip.HotelManagement.entities.Room;
import com.anudip.HotelManagement.service.RoomService;
import com.anudip.HotelManagement.dao.RoomDao;
import com.anudip.HotelManagement.daoImpl.RoomDaoImpl;

public class RoomServiceImpl implements RoomService{
	
	RoomDao roomDao = new RoomDaoImpl();

	@Override
	public boolean saveRoom(Room room) {
		
		return roomDao.saveRoom(room);
	}

	@Override
	public List<Room> getAllRooms() {
		
		return roomDao.getAllRooms();
	}

	@Override
	public Room getRoomById(int roomId) {
		
		return roomDao.getRoomById(roomId);
	}

	@Override
	public boolean deleteRoom(int roomId) {
	
		return roomDao.deleteRoom(roomId);
	}

	@Override
	public List<Room> getRoomsByHotel(int hotelId) {
		
		return roomDao.getRoomsByHotel(hotelId);
	}

}
