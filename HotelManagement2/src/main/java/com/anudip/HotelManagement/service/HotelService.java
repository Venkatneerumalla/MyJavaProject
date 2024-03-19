package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Hotel;

public interface HotelService {

    public boolean saveHotel(Hotel hotel);

    public List<Hotel> getAllHotels();

    public Hotel getHotelById(Long hotelId);

    public boolean deleteHotel(Long hotelId);
}
