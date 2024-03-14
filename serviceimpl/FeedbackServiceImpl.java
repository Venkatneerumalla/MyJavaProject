package com.anudip.HotelManagement.serviceimpl;

import java.util.List;

import org.hibernate.Session;

import com.anudip.HotelManagement.dao.FeedbackDAO;
import com.anudip.HotelManagement.entities.Feedback;
import com.anudip.HotelManagement.service.FeedbackService;
import com.anudip.HotelManagement.utils.HibernateUtil;

public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackDAO feedbackDAO;

    public FeedbackServiceImpl(FeedbackDAO feedbackDAO) {
        this.feedbackDAO = feedbackDAO;
    }

    @Override
    public void addFeedback(Feedback feedback) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            feedbackDAO.addFeedback(feedback);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Feedback getFeedbackById(Long feedbackId) {
        try (Session session = HibernateUtil.getSession()) {
            return feedbackDAO.getFeedbackById(feedbackId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        try (Session session = HibernateUtil.getSession()) {
            return feedbackDAO.getAllFeedbacks();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            feedbackDAO.updateFeedback(feedback);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFeedback(Long feedbackId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            feedbackDAO.deleteFeedback(feedbackId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
