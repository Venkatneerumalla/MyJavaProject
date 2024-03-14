package com.anudip.HotelManagement.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private Double roomPrice;
    private Integer capacity;
    private String roomType;

    @ManyToOne(fetch = FetchType.EAGER) // Consider EAGER for smaller datasets only
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Room(Long roomId, Double roomPrice, Integer capacity, String roomType, Hotel hotel) {
		super();
		this.roomId = roomId;
		this.roomPrice = roomPrice;
		this.capacity = capacity;
		this.roomType = roomType;
		this.hotel = hotel;
	}

	public Room() {
		super();
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomPrice=" + roomPrice + ", capacity=" + capacity + ", roomType="
				+ roomType + ", hotel=" + hotel + "]";
	}
	
	
    
}