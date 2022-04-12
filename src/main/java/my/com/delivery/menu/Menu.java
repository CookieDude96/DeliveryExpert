package my.com.delivery.menu;


import java.util.Scanner;

import my.com.delivery.user.User;
import my.com.delivery.user.UserDAO;
import my.com.delivery.deliveryNote.DisplayInfo;
import my.com.delivery.order.OrderDAO;

//phoneNum not exceed 11 digit
//email must come with @
//view user

public class Menu {
	public static void printMenu() {
		System.out.println("Welcome to DeliveryExpert system");
		System.out.println("===============MENU===============");
		System.out.println("1. Add user");
		System.out.println("2. Menu");
		System.out.println("3. View users");
		System.out.println("4. New Delivery Order");
		System.out.println("5. Delivery Note");
		System.out.println("0. Exit");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		OrderDAO orderDAO = new OrderDAO();
		UserDAO userDAO = new UserDAO();
		
		printMenu();
		int choice = 0;

		/* 123@gmail.com 012333 */

		do {
			System.out.print("\n\nEnter your choice: ");
			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				System.out.println("Enter user name - ");
				String userName = scanner.nextLine();
				String userEmail = "";
				do {
					if (!userEmail.equals("") && !userEmail.contains("@")) {
						System.out.println("\nPlease enter valid email\n");
					}
					System.out.println("Enter user email - ");
					userEmail = scanner.nextLine();
				} while (!userEmail.contains("@"));

				System.out.println("Enter user address - ");
				String userAddress = scanner.nextLine();
				String userPhoneNum = "";
				do {
					if (!userPhoneNum.equals("") && (userPhoneNum.length() < 10 || userPhoneNum.length() > 11)) {
						System.out.println("\nPhone number should be 10/11 digits only\n");
					}
					System.out.println("Enter user phone number - ");
					userPhoneNum = scanner.nextLine();

					// int check

				} while (userPhoneNum.length() < 10 || userPhoneNum.length() > 11);

				User user = new User(userName, userEmail, userPhoneNum, userAddress);
				if (userDAO.addUser(user)) {
					System.out.println("User has been added successfully");
				}
				break;
			case 2:
				printMenu();
				break;

			case 3:
				userDAO.showAllUsers();
				break;
			case 4:
				
				orderDAO.newOrder();

				break;
			case 5:
				System.out.print("Enter Order ID: ");
				int orderID = Integer.parseInt(scanner.nextLine());
							
				
				DisplayInfo display = new DisplayInfo();

				System.out.println("==========Delivery Note==========");
				System.out.println("1. Print Delivery Note");
				System.out.println("2. Email Delivey Note");
				System.out.println("3. Back");
				System.out.print("Insert input:");
				choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {
				case 1:
					System.out.println("Print Delivery Note");

					display.print(orderID);
					break;

				case 2:
					System.out.println("Email Delivery Note");
					display.email(orderID);
					break;

				default:
					break;
				}

				break;
				
//			case 6:
//				
//				orderDAO.readOrderList();
//				break;

			case 0:
				System.out.println("Exiting the application...");
				break;

			default:
				System.out.println("Invalid option! Please try again");
				break;
			}
		} while (choice != 0);
	}

}
