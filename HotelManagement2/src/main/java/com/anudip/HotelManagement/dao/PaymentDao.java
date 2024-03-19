package com.anudip.HotelManagement.dao;

import java.util.List;

import com.anudip.HotelManagement.entities.Booking;
import com.anudip.HotelManagement.entities.Payment;

public interface PaymentDao {

    public boolean savePayment(Payment payment);

    public List<Payment> getAllPayments();

    public Payment getPaymentById(Long paymentId);

    public boolean deletePayment(Long paymentId);

}
