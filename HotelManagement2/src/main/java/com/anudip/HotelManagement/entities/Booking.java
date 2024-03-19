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
@Table(name = "bookings")
public class Booking {
	
	@ColumnDefault("'A'")
	private char record_status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne(fetch = FetchType.EAGER) // Consider EAGER for smaller datasets only
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER) // Consider EAGER for smaller datasets only
    private Customer customer;

    private String checkInDate;
    private String checkOutDate;
	public char getRecord_status() {
		return record_status;
	}
	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Room getRoomId() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Booking(char record_status, Long bookingId, Room room, Customer customer, String checkInDate,
			String checkOutDate) {
		super();
		this.record_status = record_status;
		this.bookingId = bookingId;
		this.room = room;
		this.customer = customer;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	public Booking() {
		super();
	}
	@Override
	public String toString() {
		return "Booking [record_status=" + record_status + ", bookingId=" + bookingId + ", room=" + room + ", customer="
				+ customer + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}
	
    
    
}
