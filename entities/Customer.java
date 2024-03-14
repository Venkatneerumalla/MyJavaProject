package com.anudip.HotelManagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String cName;
    private String cEmail;
    private String cPhoneNumber;
    private String address;
    
    
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcPhoneNumber() {
		return cPhoneNumber;
	}
	public void setcPhoneNumber(String cPhoneNumber) {
		this.cPhoneNumber = cPhoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Customer(Long customerId, String cName, String cEmail, String cPhoneNumber, String address) {
		super();
		this.customerId = customerId;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cPhoneNumber = cPhoneNumber;
		this.address = address;
	}
	
	
	public Customer() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", cName=" + cName + ", cEmail=" + cEmail + ", cPhoneNumber="
				+ cPhoneNumber + ", address=" + address + "]";
	}

    
}