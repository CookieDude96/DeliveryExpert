package my.com.delivery.order;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)


public class DeliveryStaffDAOTest {
	
	DeliveryStaffDAO dsDAO = new DeliveryStaffDAO();
	DeliveryStaff staff;

	@Test
	@Parameters({ "1", "2", "3"})
	public void chooseStaffWorkTest(int choice) {
		dsDAO.showStaff();
		staff = dsDAO.chooseStaff(choice);
		
		boolean result = false;
		
		if (staff != null) {
			result = true;
		}
		
		assertTrue("Staff not found.", result);
	}
	
	@Test
	@Parameters({"999", "-1"})
	public void chooseStaffNotWorkTest(int choice) {
		dsDAO.showStaff();
		staff = dsDAO.chooseStaff(choice);
		
		boolean result = false;
		
		if (staff != null) {
			result = true;
		}
		
		assertFalse("Staff found.", result);
	}

}
