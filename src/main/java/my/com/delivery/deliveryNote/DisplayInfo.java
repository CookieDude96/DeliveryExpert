package my.com.delivery.deliveryNote;

import my.com.delivery.order.Order;
import my.com.delivery.order.OrderDAO;

public class DisplayInfo {
	
	OrderDAO od = new OrderDAO();	
	private Order order;
	

	public void print(int orderID) {
		order = od.getOrder(orderID);
		
		System.out.println("-----Customer Detail-----");
		System.out.println("Name: " + order.getUser().getName());
        System.out.println("Phone Number: " + order.getUser().getPhoneNum());
        System.out.println("Email: " + order.getUser().getEmail());

		System.out.println("-----Order Detail-----");
		System.out.println("Order ID: " + order.getOrderID());
		System.out.println("Delivery Date: " + order.getsDate1());
        System.out.println("Pickup Address: " + order.getPaddress());
        System.out.println("Delivery Address: " + order.getDaddress());
        System.out.println("Item Type: " + order.getItem());
        System.out.println("Item Weight: " + order.getweight() + " g");
        System.out.println("Distance: " + order.getdistance() + " km");

        if (order.getSameDayDelivery()) {
            System.out.println("Same Day Delivery: Yes");
        } else {
            System.out.println("Same Day Delivery: No");
        }

        if (order.getInsurance()) {
            System.out.println("Insurance: Yes");
        } else {
            System.out.println("Insurance: No");
        }
        System.out.println("Final Charge: RM" + order.getfinal_total());

		System.out.println("-----Delivery Staff-----");
		System.out.println("Name: " + order.getStaff().getDeliveryStaffName());
		System.out.println("Phone Number: " + order.getStaff().getDeliveryStaffNum());	
	}

	public void email(int orderID) {
		order = od.getOrder(orderID);
		
		System.out.println("-----Customer Detail-----");
		System.out.println("Name: " + order.getUser().getName());
        System.out.println("Phone Number: " + order.getUser().getPhoneNum());
        System.out.println("Email: " + order.getUser().getEmail());

		System.out.println("-----Order Detail-----");
		System.out.println("Order ID: " + order.getOrderID());
		System.out.println("Delivery Date: " + order.getsDate1());
        System.out.println("Pickup Address: " + order.getPaddress());
        System.out.println("Delivery Address: " + order.getDaddress());
        System.out.println("Item Type: " + order.getItem());
        System.out.println("Item Weight: " + order.getweight() + " g");
        System.out.println("Distance: " + order.getdistance() + " km");

        if (order.getSameDayDelivery()) {
            System.out.println("Same Day Delivery: Yes");
        } else {
            System.out.println("Same Day Delivery: No");
        }

        if (order.getInsurance()) {
            System.out.println("Insurance: Yes");
        } else {
            System.out.println("Insurance: No");
        }
        System.out.println("Final Charge: RM" + order.getfinal_total());

		System.out.println("-----Delivery Staff-----");
		System.out.println("Name: " + order.getStaff().getDeliveryStaffName());
		System.out.println("Phone Number: " + order.getStaff().getDeliveryStaffNum());
	}
	
}