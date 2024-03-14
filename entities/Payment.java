package com.anudip.HotelManagement.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne(fetch = FetchType.EAGER) // Consider EAGER for smaller datasets only
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private Double amount;
    private String paymentMethod;
    private Date paymentDate;
    
    
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Payment(Long paymentId, Booking booking, Double amount, String paymentMethod, Date paymentDate) {
		super();
		this.paymentId = paymentId;
		this.booking = booking;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
	}
	public Payment() {
		super();
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", booking=" + booking + ", amount=" + amount + ", paymentMethod="
				+ paymentMethod + ", paymentDate=" + paymentDate + "]";
	}

    
    
}