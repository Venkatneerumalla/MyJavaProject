package com.anudip.HotelManagement.dao;

import com.anudip.HotelManagement.entities.Room;
import java.util.List;

public interface RoomDAO {

    void addRoom(Room room);

    Room getRoomById(Long roomId);

    List<Room> getAllRooms();

    void updateRoom(Room room);

    void deleteRoom(Long roomId);
}
