package com.anudip.HotelManagement.dao;

import com.anudip.HotelManagement.entities.Customer;
import java.util.List;

public interface CustomerDAO {

    void addCustomer(Customer customer);

    Customer getCustomerById(Long customerId);

    List<Customer> getAllCustomers();

    void updateCustomer(Customer customer);

    void deleteCustomer(Long customerId);
}
