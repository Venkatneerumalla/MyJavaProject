package com.anudip.HotelManagement.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "payments")
public class Payment {
	
	@ColumnDefault("'A'")
	private char record_status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne(fetch = FetchType.EAGER) // Consider EAGER for smaller datasets only
    private Booking booking;

    private Double amount;
    private String paymentMethod;
    private String paymentDate;
	public char getRecord_status() {
		return record_status;
	}
	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}
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
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Payment(char record_status, Long paymentId, Booking booking, Double amount, String paymentMethod,
			String paymentDate) {
		super();
		this.record_status = record_status;
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
		return "Payment [record_status=" + record_status + ", paymentId=" + paymentId + ", booking=" + booking
				+ ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", paymentDate=" + paymentDate + "]";
	}
	
	
    
    
}