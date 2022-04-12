package my.com.delivery.deliveryNote;

import my.com.delivery.order.Order;
import my.com.delivery.user.User;

public class DisplayInfo {
	private Order order;
	//String name = order.getUser.getName();
	//String phoneNum = order.getUser.getPhoneNum();
	//String email = order.getUser.getEmail();
	
	//int orderID = order.getOrderID();
	String date = order.getsDate1();
	String pickupAddress = order.getPaddress();
	String deliveryAddress = order.getDaddress();
	String item = order.getItem();
	double weight = order.getweight();
	double distance = order.getdistance();
	boolean sameDayDelivery = order.getSameDayDelivery();
	boolean insurance = order.getInsurance();
	double finalCharge = order.getfinal_total();

	String staffName = order.getStaff().getDeliveryStaffName();
	String staffNum = order.getStaff().getDeliveryStaffNum();
	

	public void print(int orderID) {
		System.out.println("-----Customer Detail-----");
		//System.out.println("Name: " + name);
        //System.out.println("Phone Number: " + phoneNum);

		System.out.println("-----Order Detail-----");
		System.out.println("Delivery Date: " + date);
        System.out.println("Pickup Address: " + pickupAddress);
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Item Type: " + item);
        System.out.println("Item Weight: " + weight + " g");
        System.out.println("Distance: " + distance + " km");

        if (sameDayDelivery) {
            System.out.println("Same Day Delivery: Yes");
        } else {
            System.out.println("Same Day Delivery: No");
        }

        if (insurance) {
            System.out.println("Insurance: Yes");
        } else {
            System.out.println("Insurance: No");
        }
        System.out.println("Final Charge: RM" + finalCharge);

		System.out.println("-----Delivery Staff-----");
		System.out.println("Name: " + staffName);
		System.out.println("Phone Number" + staffNum);	
	}

	public void email(int orderID) {
		System.out.println("-----Customer Detail-----");
		//System.out.println("Name: " + name);
        //System.out.println("Phone Number: " + phoneNum);
		//System.out.println("Email: " + email);

		System.out.println("-----Order Detail-----");
		System.out.println("Delivery Date: " + date);
        System.out.println("Pickup Address: " + pickupAddress);
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Item Type: " + item);
        System.out.println("Item Weight: " + weight + " g");
        System.out.println("Distance: " + distance + " km");

        if (sameDayDelivery) {
            System.out.println("Same Day Delivery: Yes");
        } else {
            System.out.println("Same Day Delivery: No");
        }

        if (insurance) {
            System.out.println("Insurance: Yes");
        } else {
            System.out.println("Insurance: No");
        }
        System.out.println("Final Charge: RM" + finalCharge);

		System.out.println("-----Delivery Staff-----");
		System.out.println("Name: " + staffName);
		System.out.println("Phone Number" + staffNum);	
	}
	
}