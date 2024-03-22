package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Customer;

public interface CustomerService {

    public boolean saveCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(int customerId);

    public boolean deleteCustomer(int customerId);
}
