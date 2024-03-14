package com.anudip.HotelManagement.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.anudip.HotelManagement.dao.FeedbackDAO;
import com.anudip.HotelManagement.entities.Feedback;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class FeedbackDAOImpl implements FeedbackDAO {

    @Override
    public void addFeedback(Feedback feedback) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(feedback);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Feedback getFeedbackById(Long feedbackId) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Feedback.class, feedbackId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Feedback> getAllFeedbacks() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from Feedback").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.update(feedback);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFeedback(Long feedbackId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Feedback feedback = session.get(Feedback.class, feedbackId);
            if (feedback != null) {
                session.delete(feedback);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
