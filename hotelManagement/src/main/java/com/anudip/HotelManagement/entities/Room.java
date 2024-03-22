package com.anudip.HotelManagement.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "rooms")
public class Room {
	
	@ColumnDefault("'A'")
	private char record_status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    private double roomPrice;
    private int capacity;
    private String roomType;

    @ManyToOne(fetch = FetchType.EAGER) // Consider EAGER for smaller datasets only
    private Hotel hotel;

	public char getRecord_status() {
		return record_status;
	}

	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
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

	public Room(char record_status, int roomId, double roomPrice, int capacity, String roomType, Hotel hotel) {
		super();
		this.record_status = record_status;
		this.roomId = roomId;
		this.roomPrice = roomPrice;
		this.capacity = capacity;
		this.roomType = roomType;
		this.hotel = hotel;
	}

	public Room() {
		super();
	}

	public Room(int roomId2, double price, int capacity2, String type, Hotel hotel2) {
		this.roomId=roomId2;
		this.roomPrice=price;
		this.capacity=capacity2;
		this.roomType=type;
		this.hotel=hotel2;
	}

	@Override
	public String toString() {
		return "Room [record_status=" + record_status + ", roomId=" + roomId + ", roomPrice=" + roomPrice
				+ ", capacity=" + capacity + ", roomType=" + roomType + ", hotel=" + hotel + "]";
	}

	
	
    
}