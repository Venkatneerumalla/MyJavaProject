package com.anudip.HotelManagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "customers")
public class Customer {
	
	@ColumnDefault("'A'")
	private char record_status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String cName;
    private String cEmail;
    private Long cPhoneNumber;
    private String address;
	public char getRecord_status() {
		return record_status;
	}
	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
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
	public Long getcPhoneNumber() {
		return cPhoneNumber;
	}
	public void setcPhoneNumber(Long cPhoneNumber) {
		this.cPhoneNumber = cPhoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer(char record_status, int customerId, String cName, String cEmail, Long cPhoneNumber,
			String address) {
		super();
		this.record_status = record_status;
		this.customerId = customerId;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cPhoneNumber = cPhoneNumber;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [record_status=" + record_status + ", customerId=" + customerId + ", cName=" + cName
				+ ", cEmail=" + cEmail + ", cPhoneNumber=" + cPhoneNumber + ", address=" + address + "]";
	}
	public Customer() {
		super();
	}
	public Customer(int customerId2, String cName2, String cEmail2, Long cPhoneNumber2, String cAddress) {
		this.customerId=customerId2;
		this.cName=cName2;
		this.cEmail=cEmail2;
		this.cPhoneNumber=cPhoneNumber2;
		this.address = cAddress;
	}
    
    
}