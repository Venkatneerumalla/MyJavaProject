package com.anudip.HotelManagement.serviceImpl;

import java.util.List;

import com.anudip.HotelManagement.entities.Feedback;
import com.anudip.HotelManagement.service.FeedbackService;
import com.anudip.HotelManagement.dao.FeedbackDao;
import com.anudip.HotelManagement.daoImpl.FeedbackDaoImpl;

public class FeedbackServiceImpl implements FeedbackService{
	
	FeedbackDao feedbackDao = new FeedbackDaoImpl();

	@Override
	public boolean saveFeedback(Feedback feedback) {
		
		return feedbackDao.saveFeedback(feedback);
	}

	@Override
	public List<Feedback> getAllFeedback() {
		
		return feedbackDao.getAllFeedback();
	}

	@Override
	public Feedback getFeedbackById(Long feedbackId) {
		
		return feedbackDao.getFeedbackById(feedbackId);
	}

	@Override
	public boolean deleteFeedback(Long feedbackId) {
		
		return feedbackDao.deleteFeedback(feedbackId);
	}

}
