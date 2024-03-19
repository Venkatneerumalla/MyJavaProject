package com.anudip.HotelManagement.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.anudip.HotelManagement.dao.PaymentDao;
import com.anudip.HotelManagement.entities.Booking;
import com.anudip.HotelManagement.entities.Payment;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public boolean savePayment(Payment payment) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(payment);
			session.getTransaction().commit();
			// commit
			session.close();
			return true;

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

	@Override
	public List<Payment> getAllPayments() {
		try (Session session = HibernateUtil.getSession()) {
			List<Payment> payments = session.createQuery("from Payment", Payment.class).getResultList();
			System.out.println("Payment details retrieved successfully.");
			return payments;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Payment getPaymentById(Long paymentId) {
		try (Session session = HibernateUtil.getSession()) {
			Payment payment = session.get(Payment.class, paymentId);
			return payment;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	@Override
	public boolean deletePayment(Long paymentId) {
		try (Session session = HibernateUtil.getSession()) {
			Payment payment = session.get(Payment.class, paymentId);

			session.beginTransaction();
			if (payment != null) {
				payment.setRecord_status('I');
				session.saveOrUpdate(payment);
				session.getTransaction().commit();
				System.out.println("Payment deleted successfully.");
				return true;
			} else {
				System.out.println("Payment details not found");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

   
}
