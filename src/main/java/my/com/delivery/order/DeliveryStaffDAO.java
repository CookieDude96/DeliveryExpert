package my.com.delivery.order;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryStaffDAO {
	Scanner scanner = new Scanner(System.in);
	List<DeliveryStaff> staffList = new ArrayList<>();

	public void readStaffList() {

		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("DeliveryStaff.txt"));

			String read;

			while ((read = reader.readLine()) != null) {
				String[] collectData = read.split(",");

				String name = collectData[0].trim();
				String num = collectData[1].trim();

				DeliveryStaff obj = new DeliveryStaff(name, num);
				staffList.add(obj);
			}

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<DeliveryStaff> getStaffList() {
		readStaffList();

		return staffList;
	}

	public DeliveryStaff chooseStaff() {
		readStaffList();

		int i = 1;
		System.out.println("Delivery Staff");
		System.out.println("==============");

		for (DeliveryStaff staff : staffList) {
			System.out.println(i + ". " + staff.toString());
			i++;
		}

		System.out.print("Choose delivery staff: ");
		int choice = scanner.nextInt();
		choice = choice - 1;

		return staffList.get(choice);
	}

	public DeliveryStaff getStaffByPhoneNum(String phoneNum) {
		readStaffList();

		for (DeliveryStaff staff : staffList) {
			// System.out.println(staff.toString());

			if (phoneNum.equals(staff.getDeliveryStaffNum())) {
				return staff;
			}
		}
		return null;
	}
}
