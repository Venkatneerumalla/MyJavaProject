package com.anudip.HotelManagement.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "feedback")
public class Feedback {
	
	@ColumnDefault("'A'")
	private char record_status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    private String comment;
    private Integer rating;

    @OneToOne(fetch = FetchType.EAGER) // Consider EAGER for smaller datasets only
    private Booking booking;

	public char getRecord_status() {
		return record_status;
	}

	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Feedback(char record_status, Long feedbackId, String comment, Integer rating, Booking booking) {
		super();
		this.record_status = record_status;
		this.feedbackId = feedbackId;
		this.comment = comment;
		this.rating = rating;
		this.booking = booking;
	}

	public Feedback() {
		super();
	}

	@Override
	public String toString() {
		return "Feedback [record_status=" + record_status + ", feedbackId=" + feedbackId + ", comment=" + comment
				+ ", rating=" + rating + ", booking=" + booking + "]";
	}

	

	
    
    
}