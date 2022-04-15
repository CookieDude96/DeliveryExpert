package my.com.delivery.menu;

import java.util.Scanner;

import my.com.delivery.user.User;
import my.com.delivery.user.UserDAO;
import my.com.delivery.order.OrderDAO;
import my.com.delivery.deliveryNote.DeliveryNote;
//phoneNum not exceed 11 digit
//email must come with @
//view user

public class Menu {
	public static void printMenu() {
		System.out.println("\nWelcome to DeliveryExpert system");
		System.out.println("===============MENU===============");
		System.out.println("1. Add user");
		System.out.println("2. View users");
		System.out.println("3. New Delivery Order");
		System.out.println("4. Delivery Note");
		System.out.println("0. Exit");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		OrderDAO orderDAO = new OrderDAO();
		UserDAO userDAO = new UserDAO();
		
		
		int choice = 0;

		/* 123@gmail.com 012333 */

		do {
			printMenu();
			System.out.print("\nEnter your choice: ");
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
				
				System.out.println("Press ENTER to go back to menu.");
				scanner.nextLine();
				
				break;

			case 2:
				userDAO.showAllUsers();
				
				System.out.println("Press ENTER to go back to menu.");
				scanner.nextLine();
				
				break;

			case 3:
				orderDAO.newOrder();
				
				System.out.println("Press ENTER to go back to menu.");
				scanner.nextLine();
				
				break;

			case 4:
				System.out.print("Enter Order ID: ");
				int orderID = Integer.parseInt(scanner.nextLine());

				DeliveryNote display = new DeliveryNote();

				System.out.println("\n==========Delivery Note==========");
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
				
				System.out.println("Press ENTER to go back to menu.");
				scanner.nextLine();
				
				break;

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
