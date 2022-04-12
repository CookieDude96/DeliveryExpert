package my.com.delivery.order;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO {
	Scanner scanner = new Scanner(System.in);

	public void newOrder() {
		System.out.println("***********************************");
		System.out.println("           Delivery Expert         ");
		System.out.println("***********************************");

		System.out.println("Enter user phone number: ");
		String userPhoneNum = scanner.nextLine(); // need to do checking if user exist or not

		// if (userPhoneNum == user.getPhoneNum())

		// Enter date and validate the data format
		System.out.println("Please enter the delivery date (dd/MM/yyyy): ");
		String sDate1 = scanner.nextLine();

		try {
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
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

		Order newOrder = new Order(sDate1, Paddress, Daddress, sameDayDelivery, insurance, Pcode, Dcode, item, weight,
				distance);

		newOrder.toString();
		
		try {
			FileOutputStream f = new FileOutputStream(new File("Order.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			List<Order> orders = new ArrayList<>();
			orders.add(newOrder);
			// Write objects to file
			o.writeObject(newOrder);

			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
