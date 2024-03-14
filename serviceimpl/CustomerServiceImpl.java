package com.anudip.HotelManagement.serviceimpl;

import java.util.List;

import org.hibernate.Session;

import com.anudip.HotelManagement.dao.CustomerDAO;
import com.anudip.HotelManagement.entities.Customer;
import com.anudip.HotelManagement.service.CustomerService;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void addCustomer(Customer customer) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            customerDAO.addCustomer(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        try (Session session = HibernateUtil.getSession()) {
            return customerDAO.getCustomerById(customerId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try (Session session = HibernateUtil.getSession()) {
            return customerDAO.getAllCustomers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            customerDAO.updateCustomer(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(Long customerId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            customerDAO.deleteCustomer(customerId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
