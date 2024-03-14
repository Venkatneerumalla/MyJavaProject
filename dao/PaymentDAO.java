package com.anudip.HotelManagement.dao;

import com.anudip.HotelManagement.entities.Payment;
import java.util.List;

public interface PaymentDAO {

    void addPayment(Payment payment);

    Payment getPaymentById(Long paymentId);

    List<Payment> getAllPayments();

    void updatePayment(Payment payment);

    void deletePayment(Long paymentId);
}
