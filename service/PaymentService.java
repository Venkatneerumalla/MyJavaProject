package com.anudip.HotelManagement.service;

import java.util.List;

import com.anudip.HotelManagement.entities.Payment;

public interface PaymentService {

    public void addPayment(Payment payment);

    public Payment getPaymentById(Long paymentId);

    public List<Payment> getAllPayments();

    public void updatePayment(Payment payment);

    public void deletePayment(Long paymentId);
}
