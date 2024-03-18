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

import com.anudip.HotelManagement.dao.HotelDAO;
import com.anudip.HotelManagement.entities.Hotel;
import com.anudip.HotelManagement.serviceimpl.HotelServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceImplTest {

    @Mock
    private HotelDAO hotelDAO;

    @InjectMocks
    private HotelServiceImpl hotelServiceImpl;

    @Test
    public void testAddHotel() {
        Hotel hotel = new Hotel();
        hotel.setHotelName("Test Hotel");
        hotelServiceImpl.addHotel(hotel);
        verify(hotelDAO, times(1)).addHotel(hotel);
    }

    @Test
    public void testGetHotelById() {
        Long hotelId = 1L;
        Hotel mockHotel = new Hotel();
        mockHotel.setHotelId(hotelId);
        mockHotel.setHotelName("Retrieved Hotel");
        when(hotelDAO.getHotelById(hotelId)).thenReturn(mockHotel);
        Hotel retrievedHotel = hotelServiceImpl.getHotelById(hotelId);
        assertEquals(mockHotel, retrievedHotel);
    }

    @Test
    public void testGetAllHotels() {
        List<Hotel> mockHotels = new ArrayList<>();
        mockHotels.add(new Hotel());
        mockHotels.add(new Hotel());
        when(hotelDAO.getAllHotels()).thenReturn(mockHotels);
        List<Hotel> retrievedHotels = hotelServiceImpl.getAllHotels();
        assertEquals(mockHotels, retrievedHotels);
    }

    @Test
    public void testUpdateHotel() {
        Hotel hotel = new Hotel();
        hotel.setHotelId(2L);
        hotelServiceImpl.updateHotel(hotel);
        verify(hotelDAO, times(1)).updateHotel(hotel);
    }

    @Test
    public void testDeleteHotel() {
        Long hotelId = 3L;
        hotelServiceImpl.deleteHotel(hotelId);
        verify(hotelDAO, times(1)).deleteHotel(hotelId);
    }
}
