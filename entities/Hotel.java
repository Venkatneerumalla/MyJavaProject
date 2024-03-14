package com.anudip.HotelManagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String hotelName;
    private String location;
    private String phoneNumber;
    private String hotelEmail;
    
    
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHotelEmail() {
		return hotelEmail;
	}
	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}
	public Hotel(Long hotelId, String hotelName, String location, String phoneNumber, String hotelEmail) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.hotelEmail = hotelEmail;
	}
	public Hotel() {
		super();
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", location=" + location + ", phoneNumber="
				+ phoneNumber + ", hotelEmail=" + hotelEmail + "]";
	}

    
}
