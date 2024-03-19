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
    private Long roomId;

    private Double roomPrice;
    private Integer capacity;
    private String roomType;

    @ManyToOne(fetch = FetchType.EAGER) // Consider EAGER for smaller datasets only
    private Hotel hotel;

	public char getRecord_status() {
		return record_status;
	}

	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}

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

	public Room(char record_status, Long roomId, Double roomPrice, Integer capacity, String roomType, Hotel hotel) {
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

	@Override
	public String toString() {
		return "Room [record_status=" + record_status + ", roomId=" + roomId + ", roomPrice=" + roomPrice
				+ ", capacity=" + capacity + ", roomType=" + roomType + ", hotel=" + hotel + "]";
	}

	
	
    
}