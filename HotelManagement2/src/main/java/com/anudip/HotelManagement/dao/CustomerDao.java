package com.anudip.HotelManagement.dao;

import java.util.List;

import com.anudip.HotelManagement.entities.Customer;

public interface CustomerDao {

    public boolean saveCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(Long customerId);

    public boolean deleteCustomer(Long customerId);
}
