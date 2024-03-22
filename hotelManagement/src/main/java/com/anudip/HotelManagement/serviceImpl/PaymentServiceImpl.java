package com.anudip.HotelManagement.serviceImpl;

import java.util.List;

import com.anudip.HotelManagement.dao.PaymentDao;
import com.anudip.HotelManagement.daoImpl.PaymentDaoImpl;
import com.anudip.HotelManagement.entities.Payment;
import com.anudip.HotelManagement.service.PaymentService;

public class PaymentServiceImpl implements PaymentService{
	
	PaymentDao paymentDao = new PaymentDaoImpl();

	@Override
	public boolean savePayment(Payment payment) {
		
		return paymentDao.savePayment(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		
		return paymentDao.getAllPayments();
	}

	@Override
	public Payment getPaymentById(int paymentId) {
		
		return paymentDao.getPaymentById(paymentId);
	}

	@Override
	public boolean deletePayment(int paymentId) {
		
		return paymentDao.deletePayment(paymentId);
	}

	

}
