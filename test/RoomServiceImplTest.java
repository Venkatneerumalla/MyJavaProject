package com.anudip.HotelManagement.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.anudip.HotelManagement.dao.RoomDAO;
import com.anudip.HotelManagement.entities.Room;
import com.anudip.HotelManagement.serviceimpl.RoomServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RoomServiceImplTest {

    @Mock
    private RoomDAO roomDAO;

    @InjectMocks
    private RoomServiceImpl roomServiceImpl;

    @Test
    public void testAddRoom() {
        Room room = new Room();
        room.setRoomId(101L);
        roomServiceImpl.addRoom(room);
        verify(roomDAO, times(1)).addRoom(room);
    }

    @Test
    public void testGetRoomById() {
        Long roomId = 101L;
        Room mockRoom = new Room();
        mockRoom.setRoomId(roomId);
        when(roomDAO.getRoomById(roomId)).thenReturn(mockRoom);
        Room retrievedRoom = roomServiceImpl.getRoomById(roomId);
        assertEquals(mockRoom, retrievedRoom);
    }

    @Test
    public void testGetAllRooms() {
        List<Room> mockRooms = new ArrayList<>();
        mockRooms.add(new Room());
        mockRooms.add(new Room());
        when(roomDAO.getAllRooms()).thenReturn(mockRooms);
        List<Room> retrievedRooms = roomServiceImpl.getAllRooms();
        assertEquals(mockRooms, retrievedRooms);
    }

    @Test
    public void testUpdateRoom() {
        Room room = new Room();
        room.setRoomId(2L);
        roomServiceImpl.updateRoom(room);
        verify(roomDAO, times(1)).updateRoom(room);
    }

    @Test
    public void testDeleteRoom() {
        Long roomId = 3L;
        roomServiceImpl.deleteRoom(roomId);
        verify(roomDAO, times(1)).deleteRoom(roomId);
    }
}
