package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Room;

public interface RoomService {

    public void addRoom(Room room);

    public Room getRoomById(Long roomId);

    public List<Room> getAllRooms();

    public void updateRoom(Room room);

    public void deleteRoom(Long roomId);
}
