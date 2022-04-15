package my.com.delivery.deliveryNote;

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
import my.com.delivery.deliveryNote.DeliveryNote;
import my.com.delivery.user.User;
import my.com.delivery.user.UserDAO;

import static org.mockito.Mockito.*;
import org.mockito.InOrder;

@RunWith(JUnitParamsRunner.class)
public class DeliveryNoteTest {

	DeliveryNote deliver = new DeliveryNote();

	@Test
	@Parameters({ "10001", "10002", "10003" })
	public void printWorksTest(int orderID) {
		
		boolean check = deliver.print(orderID);
		assertTrue("Order not found.", check);
	} 

	@Test
	@Parameters({ "99999", "00000" })
	public void printNotWorkTest(int orderID) {
		
		boolean check = deliver.print(orderID);
		assertFalse("Order should not exist", check);
	}
	
	@Test
	@Parameters({ "10001", "10002", "10003" })
	public void emailWorksTest(int orderID) {
		
		boolean check = deliver.email(orderID);
		assertTrue("Order not found.", check);
	}

	@Test
	@Parameters({ "99999", "00000" })
	public void emailNotWorkTest(int orderID) {
		
		boolean check = deliver.email(orderID);
		assertFalse("Order should not exist", check);
	}

}
