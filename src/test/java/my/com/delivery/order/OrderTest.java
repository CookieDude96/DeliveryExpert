package my.com.delivery.order;

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

@RunWith(JUnitParamsRunner.class)
public class OrderTest {

	OrderController oc = new OrderController();
	Order order;

	@Test
	@Parameters(method = "getParamOrderInfo")
	public void testOrderController(int orderID, String sDate, String Paddress, String Daddress, String sameDayDelivery,
			String insurance, int Pcode, int Dcode, int item, double weight, double distance, String userNum,
			String staffNum, Boolean expectedResult) {			

		User userMock = mock(User.class);		
		DeliveryStaff staffMock = mock(DeliveryStaff.class);
		
		order = new Order(orderID, oc.getDeliveryDate(sDate), oc.getPickUpAddress(Paddress), 
				oc.getDeliveryAddress(Daddress), oc.getSameDayDelivery(sameDayDelivery), 
				oc.getInsurance(insurance), oc.getPCode(Pcode), oc.getDCode(Dcode), 
				oc.getItem(item),oc.getWeight(weight), oc.getDistance(distance), userMock, staffMock);
		
		if (expectedResult) {
			assertNotNull("Unsuccessful to create order object.",order);
		}
		
	}

	public Object[] getParamOrderInfo() {
		File file = new File("ParamOrderInfo.txt");
		String[] input;

		ArrayList<Object> paramList = new ArrayList<Object>();

		try {
			Scanner inputFile = new Scanner(file);
			while (inputFile.hasNext()) {
				ArrayList<Object> param = new ArrayList<Object>();
				String line = inputFile.nextLine();

				input = line.split(";");
				param.add(Integer.parseInt(input[0])); // orderID
				param.add(input[1]); // sDate1
				param.add(input[2]); // Paddress
				param.add(input[3]); // Daddress
				param.add(input[4]); // sameDayDelivery
				param.add(input[5]); // insurance
				param.add(Integer.parseInt(input[6])); // Pcode
				param.add(Integer.parseInt(input[7])); // Dcode
				param.add(Integer.parseInt(input[8])); // item
				param.add(Double.parseDouble(input[9])); // weight
				param.add(Double.parseDouble(input[10])); // distance
				param.add(input[11]); // userNum
				param.add(input[12]); // staffNum
				param.add(input[13]); // expectedResult

				paramList.add(param.toArray());
			}
			inputFile.close();
		} catch (FileNotFoundException ex) {
			System.out.println("ParamOrderInfo.txt not found");
		}

		return paramList.toArray();
	}
}
