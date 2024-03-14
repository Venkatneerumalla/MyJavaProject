package com.anudip.HotelManagement.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne(fetch = FetchType.EAGER) // Consider EAGER for smaller datasets only
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER) // Consider EAGER for smaller datasets only
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Date checkInDate;
    private Date checkOutDate;
    
    
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Room getRoom() {
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
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Booking(Long bookingId, Room room, Customer customer, Date checkInDate, Date checkOutDate) {
		super();
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
		return "Booking [bookingId=" + bookingId + ", room=" + room + ", customer=" + customer + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}

    
}
