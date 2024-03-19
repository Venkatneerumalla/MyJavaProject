package com.anudip.HotelManagement.dao;

import java.util.List;

import com.anudip.HotelManagement.entities.Hotel;

public interface HotelDao {

    public boolean saveHotel(Hotel hotel);

    public List<Hotel> getAllHotels();

    public Hotel getHotelById(Long hotelId);

    public boolean deleteHotel(Long hotelId);
}
