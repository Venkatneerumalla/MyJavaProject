package com.anudip.HotelManagement.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.anudip.HotelManagement.dao.CustomerDAO;
import com.anudip.HotelManagement.entities.Customer;
import com.anudip.HotelManagement.serviceimpl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerDAO customerDAO;

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer();
        customer.setcName("Vaishu");
        customerServiceImpl.addCustomer(customer);
        verify(customerDAO, times(1)).addCustomer(customer);
    }

    @Test
    public void testGetCustomerById() {
        Long customerId = 1L;
        Customer mockCustomer = new Customer();
        mockCustomer.setCustomerId(customerId);
        mockCustomer.setcName("Vaishu");
        when(customerDAO.getCustomerById(customerId)).thenReturn(mockCustomer);
        Customer retrievedCustomer = customerServiceImpl.getCustomerById(customerId);
        assertEquals(mockCustomer, retrievedCustomer);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(new Customer());
        mockCustomers.add(new Customer());
        when(customerDAO.getAllCustomers()).thenReturn(mockCustomers);
        List<Customer> retrievedCustomers = customerServiceImpl.getAllCustomers();
        assertEquals(mockCustomers, retrievedCustomers);
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(2L);
        customerServiceImpl.updateCustomer(customer);
        verify(customerDAO, times(1)).updateCustomer(customer);
    }

    @Test
    public void testDeleteCustomer() {
        Long customerId = 3L;
        customerServiceImpl.deleteCustomer(customerId);
        verify(customerDAO, times(1)).deleteCustomer(customerId);
    }
}

