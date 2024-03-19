package com.anudip.HotelManagement.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.anudip.HotelManagement.dao.CustomerDao;
import com.anudip.HotelManagement.entities.Customer;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public boolean saveCustomer(Customer customer) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(customer);
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
	public List<Customer> getAllCustomers() {
		try (Session session = HibernateUtil.getSession()) {
			List<Customer> customers = session.createQuery("from Customer", Customer.class).getResultList();
			System.out.println("Customer details retrieved successfully.");
			return customers;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		try (Session session = HibernateUtil.getSession()) {
			Customer doctor = session.get(Customer.class, customerId);
			return doctor;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(Long customerId) {
		try (Session session = HibernateUtil.getSession()) {
			Customer customer = session.get(Customer.class, customerId);

			session.beginTransaction();
			if (customer != null) {
				customer.setRecord_status('I');
				session.saveOrUpdate(customer);
				session.getTransaction().commit();
				System.out.println("Customer deleted successfully.");
				return true;
			} else {
				System.out.println("Customer details not found");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

	

    
}
