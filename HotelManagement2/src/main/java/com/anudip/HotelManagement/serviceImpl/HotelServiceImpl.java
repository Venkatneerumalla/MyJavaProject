package com.anudip.HotelManagement.serviceImpl;

import java.util.List;

import com.anudip.HotelManagement.entities.Hotel;
import com.anudip.HotelManagement.service.HotelService;
import com.anudip.HotelManagement.dao.HotelDao;
import com.anudip.HotelManagement.daoImpl.HotelDaoImpl;

public class HotelServiceImpl implements HotelService{
	
	HotelDao hotelDao = new HotelDaoImpl();

	@Override
	public boolean saveHotel(Hotel hotel) {
		
		return hotelDao.saveHotel(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelDao.getAllHotels();
	}

	@Override
	public Hotel getHotelById(Long hotelId) {
		
		return hotelDao.getHotelById(hotelId);
	}

	@Override
	public boolean deleteHotel(Long hotelId) {
		
		return hotelDao.deleteHotel(hotelId);
	}

}
