package com.anudip.HotelManagement.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.anudip.HotelManagement.dao.FeedbackDao;
import com.anudip.HotelManagement.entities.Feedback;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class FeedbackDaoImpl implements FeedbackDao {

	@Override
	public boolean saveFeedback(Feedback feedback) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(feedback);
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
	public List<Feedback> getAllFeedback() {
		try (Session session = HibernateUtil.getSession()) {
			List<Feedback> feedbacks = session.createQuery("from Feedback", Feedback.class).getResultList();
			System.out.println("Feedback details retrieved successfully.");
			return feedbacks;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Feedback getFeedbackById(Long feedbackId) {
		try (Session session = HibernateUtil.getSession()) {
			Feedback feedback = session.get(Feedback.class, feedbackId);
			return feedback;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	@Override
	public boolean deleteFeedback(Long feedbackId) {
		try (Session session = HibernateUtil.getSession()) {
			Feedback feedback = session.get(Feedback.class, feedbackId);

			session.beginTransaction();
			if (feedback != null) {
				feedback.setRecord_status('I');
				session.saveOrUpdate(feedback);
				session.getTransaction().commit();
				System.out.println("Feedback deleted successfully.");
				return true;
			} else {
				System.out.println("Feedback details not found");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

   
}
