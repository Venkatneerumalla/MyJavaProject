package com.anudip.HotelManagement.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.anudip.HotelManagement.entities.Customer;
import com.anudip.HotelManagement.service.CustomerService;
import com.anudip.HotelManagement.serviceImpl.CustomerServiceImpl;
import com.anudip.HotelManagement.utils.HibernateUtil;

class CustomerServiceTest {

    static SessionFactory sessionFactory;
    static Session session;
    static CustomerService customerService;

    @BeforeAll
    static void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
        customerService = new CustomerServiceImpl();
    }

    @Test
    void testSaveCustomer() {
        Customer customer = new Customer('V',2L,"Venkat", "johndoe@example.com", 1234567890L,"Hyderabad");
        assertTrue(customerService.saveCustomer(customer));
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
    }

    @Test
    void testGetCustomerById() {
        Customer customer = customerService.getCustomerById(2L);
        assertNotNull(customer);
        assertEquals(2L, customer.getCustomerId());
    }

    @Test
    void testDeleteCustomer() {
        assertTrue(customerService.deleteCustomer(2L));
    }

    @AfterAll
    static void tearDown() {
        sessionFactory.close();
    }
}
