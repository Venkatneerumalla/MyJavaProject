package com.anudip.HotelManagement.dao;

import java.util.List;

import com.anudip.HotelManagement.entities.Hotel;

public interface HotelDAO {
    public void addHotel(Hotel hotel);
    public void updateHotel(Hotel hotel);
    public void deleteHotel(Long hotelId);
    public List<Hotel> getAllHotels();
	public Hotel getHotelById(Long hotelId);
}
