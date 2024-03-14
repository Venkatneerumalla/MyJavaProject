package com.anudip.HotelManagement.serviceimpl;

import java.util.List;

import org.hibernate.Session;

import com.anudip.HotelManagement.dao.PaymentDAO;
import com.anudip.HotelManagement.entities.Payment;
import com.anudip.HotelManagement.service.PaymentService;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class PaymentServiceImpl implements PaymentService {

    private PaymentDAO paymentDAO;

    public PaymentServiceImpl(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public void addPayment(Payment payment) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            paymentDAO.addPayment(payment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        try (Session session = HibernateUtil.getSession()) {
            return paymentDAO.getPaymentById(paymentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        try (Session session = HibernateUtil.getSession()) {
            return paymentDAO.getAllPayments();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updatePayment(Payment payment) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            paymentDAO.updatePayment(payment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePayment(Long paymentId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            paymentDAO.deletePayment(paymentId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
