package my.com.delivery.order;

import java.util.Scanner;

import my.com.delivery.user.User;
import my.com.delivery.user.UserDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO {
	Scanner scanner = new Scanner(System.in);
	UserDAO userDAO = new UserDAO();
	DeliveryStaffDAO deliveryStaffDAO = new DeliveryStaffDAO();

	List<User> userList = userDAO.getAllUsers();
	List<Order> orders = new ArrayList<>();

	public void newOrder() {
		System.out.println();
		System.out.println("***********************************");
		System.out.println("           Delivery Expert         ");
		System.out.println("***********************************");

		System.out.println("Enter user phone number: ");
		String userPhoneNum = scanner.nextLine(); // need to do checking if user exist or not
		
		int x = 0;

		for (User user : userList) {
			if (userPhoneNum.equals(user.getPhoneNum())) {
				x = 1;
			}
		}

		if (x == 0) {
			System.out.println("User not found. Please add new user to the system.");
			return;
		}

		// Enter date and validate the data format
		System.out.println("Please enter the delivery date (dd/MM/yyyy): ");
		String sDate1 = scanner.nextLine();

		try {			
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			Date today = new Date();
			
			if (date1.compareTo(today) < 0) {
				System.out.println("Delivery Date must be after today.");
				
				return;
			}
			
		} catch (Exception e) {

		}

		// Enter pick up address
		System.out.println("Please enter the pickup address: ");
		String Paddress = scanner.nextLine();

		// Enter pickup pos code and validate the pos code
		int Pcode;
		do {
			System.out.println("Please enter the pickup postcode: ");
			Pcode = scanner.nextInt();

			if (Pcode <= 40000 || Pcode >= 68100)
				System.out.println(Pcode + " is an invalid postcode. Please try again.");

			else
				break;

		} while (true);

		// Enter delivery address
		System.out.println("Please enter the delivery address: ");
		scanner.nextLine();
		String Daddress = scanner.nextLine();

		// Enter delivery pos code and validate the pos code
		int Dcode;
		do {
			System.out.println("Please enter the delivery postcode: ");
			Dcode = scanner.nextInt();

			if (Dcode <= 40000 || Dcode >= 68100)
				System.out.println(Dcode + " is an invalid postcode. Please try again.");

			else
				break;

		} while (true);

		// Enter 1 or 2 to choose Parcel or Document
		String item;

		do {
			System.out.println("Please choose the item type: ");
			System.out.println("1. Parcel");
			System.out.println("2. Document");
			int itemChoice = scanner.nextInt();

			if (itemChoice == 1) {
				System.out.println("You have selected Parcel.");
				item = "Parcel";
				break;
			} else if (itemChoice == 2) {
				System.out.println("You have selected Document.");
				item = "Document";
				break;
			} else {
				System.out.println("Invalid Input. Please try again.");

			}
		} while (true);

		// Enter the item weight in grams
		System.out.println("Please enter the item weight (g): ");
		double weight = scanner.nextDouble();

		double distance = 0;
		// Enter distance and need to be limit to 100km
		do {
			System.out.println("Please enter the distance (km): ");
			distance = scanner.nextDouble();
			scanner.nextLine();

			if (distance > 100)
				System.out.println("Exceed the limit of 100 km. Please try again.");

			else
				break;

		} while (true);

		// Whether want to add same day delivery fee
		boolean sameDayDelivery = false;
		do {
			System.out.println("Additional RM10.00 for same day delivery. (y/n)");
			String decision1 = scanner.nextLine();

			if (decision1.equals("y")) {
				decision1 = "Yes";
				sameDayDelivery = true;
				break;
			}

			else if (decision1.equals("n")) {
				decision1 = "No";
				break;
			}

			else {
				System.out.println("Invalid Input. Please try again.");

			}
		} while (true);

		// Whether want to add delivery insurance
		boolean insurance = false;

		do {
			System.out.println("Additional RM15.00 for delivery insurance. (y/n)");
			String decision2 = scanner.nextLine();

			if (decision2.equals("y")) {
				decision2 = "Yes";
				insurance = true;
				break;
			}

			else if (decision2.equals("n")) {
				decision2 = "No";
				break;
			}

			else {
				System.out.println("Invalid Input. Please try again.");
			}
		} while (true);

		try {
			BufferedReader reader;

			int lines = 0;

			reader = new BufferedReader(new FileReader("Order.txt"));

			while (reader.readLine() != null) {
				lines++;
			}

			reader.close();
			lines += 10001;

			User user = userDAO.getUserByPhoneNum(userPhoneNum);
			deliveryStaffDAO.showStaff();
			System.out.print("Choose delivery staff: ");
			int choice = scanner.nextInt();
			DeliveryStaff staff = deliveryStaffDAO.chooseStaff(choice);

			Order newOrder = new Order(lines, sDate1, Paddress, Daddress, sameDayDelivery, insurance, Pcode, Dcode,
					item, weight, distance, user, staff);

			String append = newOrder.toString() + "\n"; 
			BufferedWriter writer = new BufferedWriter(new FileWriter("Order.txt", true));
			// ObjectOutputStream o = new ObjectOutputStream(f);
			// Write objects to file
			// o.writeObject(users);

			if (writer.append(append) != null) {
				System.out.println("Order had succefully recorded.");
			}

			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readOrderList() {
		try {
			BufferedReader reader; 
			reader = new BufferedReader(new FileReader("Order.txt"));

			String read;

			while ((read = reader.readLine()) != null) {
				String[] collectData = read.split(",");

				int id = Integer.parseInt(collectData[0].trim());
				String date = collectData[1].trim();
				String pAddress = collectData[2].trim();
				String dAddress = collectData[3].trim();
				boolean sameDay = Boolean.parseBoolean(collectData[4].trim());
				boolean insurance = Boolean.parseBoolean(collectData[5].trim());
				int pCode = Integer.parseInt(collectData[6].trim());
				int dCode = Integer.parseInt(collectData[7].trim());
				String item = collectData[8].trim();
				double weight = Double.parseDouble(collectData[9].trim());
				double distance = Double.parseDouble(collectData[10].trim());

				String userNum = collectData[11].trim();
				User user = userDAO.getUserByPhoneNum(userNum);

				String staffNum = collectData[12].trim();

				Order obj = new Order(id, date, pAddress, dAddress, sameDay, insurance, pCode, dCode, item, weight,
						distance, user, deliveryStaffDAO.getStaffByPhoneNum(staffNum));
				orders.add(obj);
			}

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Order getOrder(int id) {
		readOrderList();

		for (Order order : orders) {
			if (id == order.getOrderID()) {
				return order;
			}
		}
		return null;
	}

}
