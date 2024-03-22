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

		System.out.println("Enter room id: ");
		int room_id = scanner.nextInt();
		Room room = roomService.getRoomById(room_id);

		System.out.println("Enter customer id: ");
		int customer_id = scanner.nextInt();
		Customer customer = customerService.getCustomerById(customer_id);

		System.out.println("Enter check_in date: ");
		String checkin_date = scanner.nextLine();

		System.out.println("Enter check out date: ");
		String checkout_date = scanner.nextLine();

		return new Booking(bookingId, room, customer, checkin_date, checkout_date);

	}

	public static Customer customerDetails() {
		scanner.nextLine();

		System.out.println("Enter customer id: ");
		int customerId = scanner.nextInt();

		System.out.println("Enter customer name: ");
		String cName = scanner.nextLine();

		System.out.println("Enter customer email: ");
		String cEmail = scanner.nextLine();

		System.out.println("Enter customer Phone number and add L at the end: ");
		Long cPhoneNumber = scanner.nextLong();

		System.out.println("Enter customer address: ");
		String cAddress = scanner.nextLine();

		return new Customer(customerId, cName, cEmail, cPhoneNumber, cAddress);
	}

	public static Feedback feedbackDetails() {
		scanner.nextLine();

		System.out.println("Enter feedback id: ");
		int feedbackId = scanner.nextInt();

		System.out.println("Enter Comment: ");
		String comment = scanner.nextLine();

		System.out.println("Enter rating 1 to 10:");
		int rating = scanner.nextInt();

		System.out.println("Enter booking id: ");
		int bookingId = scanner.nextInt();
		Booking booking = bookingService.getBookingById(bookingId);

		return new Feedback(feedbackId, comment, rating, booking);
	}

	public static Hotel hotelDetails() {
		scanner.nextLine();

		System.out.println("Enter hotel id: ");
		int hotelId = scanner.nextInt();

		System.out.println("Enter hotel name: ");
		String hName = scanner.nextLine();

		System.out.println("Enter hotel Email: ");
		String hEmail = scanner.nextLine();

		System.out.println("Enter hotel location: ");
		String hLocation = scanner.nextLine();

		System.out.println("Enter hotel Phone Number: ");
		Long hPhoneNumber = scanner.nextLong();

		return new Hotel(hotelId, hName, hEmail, hLocation, hPhoneNumber);
	}

	public static Payment paymentDetails() {
		scanner.nextLine();

		System.out.println("Enter payment id: ");
		int paymentId = scanner.nextInt();

		System.out.println("Enter bookingId: ");
		int bookingId = scanner.nextInt();
		Booking booking = bookingService.getBookingById(bookingId);

		System.out.println("Enter amount: ");
		double amount = scanner.nextDouble();

		System.out.println("Enter payment method: ");
		String pMethod = scanner.nextLine();

		System.out.println("Enter payment date: ");
		String date = scanner.nextLine();

		return new Payment(paymentId, booking, amount, pMethod, date);

	}

	public static Room roomDetails() {
		scanner.nextLine();

		System.out.println("Enter roomId: ");
		int roomId = scanner.nextInt();

		System.out.println("Enter room price: ");
		double price = scanner.nextDouble();

		System.out.println("Enter room capacity: ");
		int capacity = scanner.nextInt();

		System.out.println("Enter room type: ");
		String type = scanner.nextLine();

		System.out.println("Enter hotel id: ");
		int hotelId = scanner.nextInt();
		Hotel hotel = hotelService.getHotelById(hotelId);

		return new Room(roomId, price, capacity, type, hotel);
	}

	public static void bookingOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new Booking ");
			System.out.println("2. Get Booking by id");
			System.out.println("3. Get all Bookings");
			System.out.println("4. Delete Booking by id");
			System.out.println("5. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Booking booking = bookingInputs();
				boolean savedEntity = bookingService.saveBooking(booking);
				System.out.println("Booking details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the Booking id: ");
				int id = scanner.nextInt();
				Booking bookingbyId = bookingService.getBookingById(id);
				System.out.println("Booking details: " + bookingbyId);
				break;

			case 3:
				List<Booking> bookings = bookingService.getAllBookings();
				for (Booking book : bookings) {
					System.out.println(book);
				}
				break;

			case 4:
				System.out.println("Enter the Booking id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = bookingService.deleteBooking(deletebyId);
				break;

			case 5:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

	public static void customerOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new Customer ");
			System.out.println("2. Get Customer by id");
			System.out.println("3. Get all Customers");
			System.out.println("4. Delete Customer by id");
			System.out.println("5. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Customer customer = customerDetails();
				boolean savedEntity = customerService.saveCustomer(customer);
				System.out.println("Customer details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the Customer id: ");
				int id = scanner.nextInt();
				Customer customerbyId = customerService.getCustomerById(id);
				System.out.println("Customer details: " + customerbyId);
				break;

			case 3:
				List<Customer> customers = customerService.getAllCustomers();
				for (Customer allCustomers : customers) {
					System.out.println(allCustomers);
				}
				break;

			case 4:
				System.out.println("Enter the Customer id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = customerService.deleteCustomer(deletebyId);
				break;

			case 5:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

	public static void feedbackOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new Feedback ");
			System.out.println("2. Get Feedback by id");
			System.out.println("3. Get all Feedbacks");
			System.out.println("4. Delete Feedback by id");
			System.out.println("5. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Feedback feedback = feedbackDetails();
				boolean savedEntity = feedbackService.saveFeedback(feedback);
				System.out.println("Feedback details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the Feedback id: ");
				int id = scanner.nextInt();
				Feedback feedbackbyId = feedbackService.getFeedbackById(id);
				System.out.println("Feedbcak details: " + feedbackbyId);
				break;

			case 3:
				List<Feedback> feedbacks = feedbackService.getAllFeedback();
				for (Feedback allFeedbacks : feedbacks) {
					System.out.println(allFeedbacks);
				}
				break;

			case 4:
				System.out.println("Enter the Feedback id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = feedbackService.deleteFeedback(deletebyId);
				break;

			case 5:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

	public static void hotelOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new Hotel ");
			System.out.println("2. Get Hotel by id");
			System.out.println("3. Get all Hotels");
			System.out.println("4. Delete Hotel by id");
			System.out.println("5. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Hotel hotel = hotelDetails();
				boolean savedEntity = hotelService.saveHotel(hotel);
				System.out.println("Hotel details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the Hotel id: ");
				int id = scanner.nextInt();
				Hotel hotelbyId = hotelService.getHotelById(id);
				System.out.println("Hotel details: " + hotelbyId);
				break;

			case 3:
				List<Hotel> hotels = hotelService.getAllHotels();
				for (Hotel allHotels : hotels) {
					System.out.println(allHotels);
				}
				break;

			case 4:
				System.out.println("Enter the Hotel id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = hotelService.deleteHotel(deletebyId);
				break;

			case 5:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

	public static void paymentOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new Payment ");
			System.out.println("2. Get Payment by id");
			System.out.println("3. Get all Payments");
			System.out.println("4. Delete Payment by id");
			System.out.println("5. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Payment payment = paymentDetails();
				boolean savedEntity = paymentService.savePayment(payment);
				System.out.println("Payment details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the Payment id: ");
				int id = scanner.nextInt();
				Payment paymentbyId = paymentService.getPaymentById(id);
				System.out.println("Payment details: " + paymentbyId);
				break;

			case 3:
				List<Payment> payments = paymentService.getAllPayments();
				for (Payment allPayments : payments) {
					System.out.println(allPayments);
				}
				break;

			case 4:
				System.out.println("Enter the Payment id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = paymentService.deletePayment(deletebyId);
				break;

			case 5:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

	public static void roomOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new Room ");
			System.out.println("2. Get Room by id");
			System.out.println("3. Get all Rooms");
			System.out.println("4. Delete Room by id");
			System.out.println("5. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Room room = roomDetails();
				boolean savedEntity = roomService.saveRoom(room);
				System.out.println("Room details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the Room id: ");
				int id = scanner.nextInt();
				Room roombyId = roomService.getRoomById(id);
				System.out.println("Room details: " + roombyId);
				break;

			case 3:
				List<Room> rooms = roomService.getAllRooms();
				for (Room allRooms : rooms) {
					System.out.println(allRooms);
				}
				break;

			case 4:
				System.out.println("Enter the Room id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = roomService.deleteRoom(deletebyId);
				break;

			case 5:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

}
