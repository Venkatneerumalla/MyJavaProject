package com.anudip.HotelManagement.dao;

import java.util.List;

import com.anudip.HotelManagement.entities.Hotel;
import com.anudip.HotelManagement.entities.Room;

public interface RoomDao {

    public boolean saveRoom(Room room);

    public List<Room> getAllRooms();

    public Room getRoomById(int roomId);

    public boolean deleteRoom(int roomId);

    public List<Room> getRoomsByHotel(int hotelId);
}
