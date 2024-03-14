package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Customer;

public interface CustomerService {

    public void addCustomer(Customer customer);

    public Customer getCustomerById(Long customerId);

    public List<Customer> getAllCustomers();

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Long customerId);
}
