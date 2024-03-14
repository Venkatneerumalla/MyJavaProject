package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Hotel;

public interface HotelService {

    public void addHotel(Hotel hotel);

    public Hotel getHotelById(Long hotelId);

    public List<Hotel> getAllHotels();

    public void updateHotel(Hotel hotel);

    public void deleteHotel(Long hotelId);
}
