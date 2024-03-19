package com.anudip.HotelManagement.serviceImpl;

import java.util.List;

import com.anudip.HotelManagement.entities.Customer;
import com.anudip.HotelManagement.service.CustomerService;
import com.anudip.HotelManagement.dao.CustomerDao;
import com.anudip.HotelManagement.daoImpl.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService{
	
	CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public boolean saveCustomer(Customer customer) {
		
		return customerDao.saveCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public boolean deleteCustomer(Long customerId) {
		
		return customerDao.deleteCustomer(customerId);
	}

}
