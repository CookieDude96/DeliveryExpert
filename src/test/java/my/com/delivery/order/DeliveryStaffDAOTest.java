package my.com.delivery.order;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeliveryStaffDAOTest {
	
	DeliveryStaffDAO dsDAO = new DeliveryStaffDAO();

	@Test
	public void testChooseStaff() {
		dsDAO.chooseStaff();
	}

}
