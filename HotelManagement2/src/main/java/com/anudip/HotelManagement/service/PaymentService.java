package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Payment;

public interface PaymentService {

    public boolean savePayment(Payment payment);

    public List<Payment> getAllPayments();

    public Payment getPaymentById(Long paymentId);

    public boolean deletePayment(Long paymentId);

}
