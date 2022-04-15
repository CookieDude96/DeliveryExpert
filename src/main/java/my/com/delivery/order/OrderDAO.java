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
	OrderController oc = new OrderController();

	List<User> userList = userDAO.getAllUsers();
	List<Order> orders = new ArrayList<>();

	public void newOrder() {
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
		System.out.println("Please enter the delivery date (dd/MM/yyyy): ");
		String sDate = oc.getDeliveryDate(scanner.nextLine());

		System.out.println("Please enter the pickup address: ");
		String Paddress = oc.getPickUpAddress(scanner.nextLine());
		
		System.out.println("Please enter the pickup postcode: ");
		int Pcode = oc.getPCode(scanner.nextInt());
		scanner.nextLine();
		
		System.out.println("Please enter the delivery address: ");
		String Daddress = oc.getDeliveryAddress(scanner.nextLine());

		System.out.println("Please enter the delivery postcode: ");
		int Dcode = oc.getDCode(scanner.nextInt());
		scanner.nextLine();
		
		System.out.println("Please choose the item type: ");
		System.out.println("1. Parcel");
		System.out.println("2. Document");
		String item = oc.getItem(scanner.nextInt());
		
		System.out.println("Please enter the item weight (g): ");
		double weight = oc.getWeight(scanner.nextDouble());
		scanner.nextLine();
		
		System.out.println("Please enter the distance (km): ");
		double distance = oc.getDistance(scanner.nextDouble());
		scanner.nextLine();
		
		System.out.println("Additional RM10.00 for same day delivery. (y/n)");
		boolean sameDayDelivery = oc.getSameDayDelivery(scanner.nextLine());
		
		System.out.println("Additional RM15.00 for delivery insurance. (y/n)");
		boolean insurance = oc.getInsurance(scanner.nextLine());

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
			DeliveryStaff staff = deliveryStaffDAO.chooseStaff();

			Order newOrder = new Order(lines, sDate, Paddress, Daddress, sameDayDelivery, insurance, Pcode, Dcode,
					item, weight, distance, user, staff);

			String append = newOrder.toString() + "\n";
			BufferedWriter writer = new BufferedWriter(new FileWriter("Order.txt", true));
			// ObjectOutputStream o = new ObjectOutputStream(f);
			// Write objects to file
			// o.writeObject(users);

			if (writer.append(append) != null) {
				System.out.println("Order had successfully recorded.");
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
				String[] collectData = read.split(";");

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
				DeliveryStaff staff = deliveryStaffDAO.getStaffByPhoneNum(staffNum);

				Order obj = new Order(id, date, pAddress, dAddress, sameDay, insurance, pCode, dCode, item, weight,
						distance, user, staff);
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
