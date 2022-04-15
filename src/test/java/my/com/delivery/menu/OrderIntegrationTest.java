package my.com.delivery.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import static org.junit.Assert.*;

import junitparams.Parameters;
import my.com.delivery.user.User;
import my.com.delivery.user.UserDAO;

import static org.mockito.Mockito.*;
import org.mockito.InOrder;

import my.com.delivery.deliveryNote.DeliveryNote;
import my.com.delivery.order.DeliveryStaff;
import my.com.delivery.order.Order;
import my.com.delivery.order.OrderController;
import my.com.delivery.order.OrderDAO;
import my.com.delivery.user.User;




public class OrderIntegrationTest {
	
	OrderController oc = new OrderController();
	Order order;
	ArrayList<Order> orderList = new ArrayList<>();
	DeliveryNote deliver = new DeliveryNote();
	
	
	@Test
	public void newOrderTest() {

		User dummyUser = new User("dummy", "dummy@dummy.my", "012345789", "dummy");
		DeliveryStaff dummyStaff = new DeliveryStaff("dummy", "012345789"); 
		
		order = new Order(10099, "05/06/2022", "Cheras", "Puchong ", true, false, 50000, 48000, 
				"Parcel", 1000, 20, dummyUser, dummyStaff);
		
		System.out.println(toString());
		
		orderList.add(order);
		
		assertEquals("List is empty", 1, orderList.size());
	}
	
	public void printTest() {
		int orderID = orderList.get(0).getOrderID();
		
		boolean check = deliver.print(orderID);
		
		assertTrue("Order not found.", check);
	}

}
