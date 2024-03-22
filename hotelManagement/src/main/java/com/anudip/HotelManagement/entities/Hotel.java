package com.anudip.HotelManagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "hotels")
public class Hotel {
	
	@ColumnDefault("'A'")
	private char record_status;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelId;

	private String hotelName;
	private String hotelEmail;
	private String location;
	private Long phoneNumber;
	public char getRecord_status() {
		return record_status;
	}
	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelEmail() {
		return hotelEmail;
	}
	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Hotel(char record_status, int hotelId, String hotelName, String hotelEmail, String location,
			Long phoneNumber) {
		super();
		this.record_status = record_status;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelEmail = hotelEmail;
		this.location = location;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Hotel [record_status=" + record_status + ", hotelId=" + hotelId + ", hotelName=" + hotelName
				+ ", hotelEmail=" + hotelEmail + ", location=" + location + ", phoneNumber=" + phoneNumber + "]";
	}
	public Hotel() {
		super();
	}
	public Hotel(int hotelId2, String hName, String hEmail, String hLocation, Long hPhoneNumber) {
		this.hotelId=hotelId2;
		this.hotelName=hName;
		this.hotelEmail=hEmail;
		this.location = hLocation;
		this.phoneNumber=hPhoneNumber;
	}
	
	
}