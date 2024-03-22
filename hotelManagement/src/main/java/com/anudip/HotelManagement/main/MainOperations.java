package com.anudip.HotelManagement.main;

import java.util.Scanner;
import com.anudip.HotelManagement.main.AllOperations;

public class MainOperations {
	static Scanner scanner = new Scanner(System.in);

	public static void mainOps() {
		while (true) {
			System.out.println("Welcome to Hotel Management System:\n " + "***********************************\n"
					+ "1.Booking Details\n" + " 2.Customer Details\n " + "3.Feedback Details \n"
					+ " 4.Hotel Details \n " +"5.Payment Details"+"6.Feedback Details"+"7. Exit\n Enter your choice");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				AllOperations.bookingOperations();
				System.out.println("******************");
				break;

			case 2:
				AllOperations.customerOperations();
				System.out.println("******************");
				break;

			case 3:
				AllOperations.feedbackOperations();
				System.out.println("******************");
				break;

			case 4:
				AllOperations.hotelOperations();
				System.out.println("******************");
				break;
				
			case 5:
				AllOperations.paymentOperations();
				System.out.println("******************");
				break;
			
			case 6:
				AllOperations.roomOperations();
				System.out.println("******************");
				break;

			case 7:
				System.exit(0);
			default:
				System.out.println("Entered wrong choice. Please choose correct choice...");
			}

		}
	}

	public static void main(String args[]) {
		mainOps();

	}
}
