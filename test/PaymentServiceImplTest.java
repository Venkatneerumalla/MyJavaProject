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

import com.anudip.HotelManagement.dao.PaymentDAO;
import com.anudip.HotelManagement.entities.Payment;
import com.anudip.HotelManagement.serviceimpl.PaymentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest {

    @Mock
    private PaymentDAO paymentDAO;

    @InjectMocks
    private PaymentServiceImpl paymentServiceImpl;

    @Test
    public void testAddPayment() {
        Payment payment = new Payment();
        payment.setAmount(100.0);
        paymentServiceImpl.addPayment(payment);
        verify(paymentDAO, times(1)).addPayment(payment);
    }

    @Test
    public void testGetPaymentById() {
        Long paymentId = 1L;
        Payment mockPayment = new Payment();
        mockPayment.setPaymentId(paymentId);
        mockPayment.setAmount(200.0);
        when(paymentDAO.getPaymentById(paymentId)).thenReturn(mockPayment);
        Payment retrievedPayment = paymentServiceImpl.getPaymentById(paymentId);
        assertEquals(mockPayment, retrievedPayment);
    }

    @Test
    public void testGetAllPayments() {
        List<Payment> mockPayments = new ArrayList<>();
        mockPayments.add(new Payment());
        mockPayments.add(new Payment());
        when(paymentDAO.getAllPayments()).thenReturn(mockPayments);
        List<Payment> retrievedPayments = paymentServiceImpl.getAllPayments();
        assertEquals(mockPayments, retrievedPayments);
    }

    @Test
    public void testUpdatePayment() {
        Payment payment = new Payment();
        payment.setPaymentId(2L);
        paymentServiceImpl.updatePayment(payment);
        verify(paymentDAO, times(1)).updatePayment(payment);
    }

    @Test
    public void testDeletePayment() {
        Long paymentId = 3L;
        paymentServiceImpl.deletePayment(paymentId);
        verify(paymentDAO, times(1)).deletePayment(paymentId);
    }
}
