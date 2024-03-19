package com.anudip.HotelManagement.main;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.hibernate.ObjectDeletedException;
//import org.junit.jupiter.api.condition.OS;

import com.anudip.HotelManagement.entities.*;
import com.anudip.HotelManagement.serviceImpl.*;
import com.anudip.HotelManagement.service.*;


public class AllOperations {
	static BookingService bookingService = new BookingServiceImpl();
	static CustomerService customerService = new CustomerServiceImpl();
	static FeedbackService feedbackService = new FeedbackServiceImpl();
	static HotelService hotelService = new HotelServiceImpl();
	static PaymentService paymentService = new PaymentServiceImpl();
	static RoomService roomService = new RoomServiceImpl();

	static Scanner scanner = new Scanner(System.in);

	// 1. appointment inputs

	public static <T> T getEntityById(Scanner scanner, String entityType) {
		System.out.print("Enter " + entityType + " ID: ");
		int entityId = scanner.nextInt();
		return null;
	}

	public static Booking bookingInputs() {
		scanner.nextLine();
		System.out.println("Enter Booking Id : ");
		int bookingId = scanner.nextInt();
		return null;

	}

}
