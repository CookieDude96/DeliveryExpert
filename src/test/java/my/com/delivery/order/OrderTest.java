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


import junitparams.Parameters;
import my.com.delivery.order.DeliveryStaff;
import my.com.delivery.order.Order;
import my.com.delivery.order.OrderController;
import my.com.delivery.user.User;
import my.com.delivery.user.UserDAO;

import static org.junit.Assert.assertNotNull;
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

@RunWith(Parameterized.class)
public class OrderTest {
	

    // fields used together with @Parameter must be public
    @Parameterized.Parameter(0)
    public String sDate1;
    @Parameterized.Parameter(1)
    public String Paddress;
    @Parameterized.Parameter(2)
    public String Daddress;
    @Parameterized.Parameter(3)
    public boolean sameDayDelivery;
    @Parameterized.Parameter(4)
    public boolean insurance;
    @Parameterized.Parameter(5)
    public int Pcode;
    @Parameterized.Parameter(6)
    public int Dcode;
    @Parameterized.Parameter(7)
    public String item;
    @Parameterized.Parameter(8)
    public double weight;
    @Parameterized.Parameter(8)
    public double distance;
}

    // creates the test data
    @Parameterized.Parameters(name = "ordertest")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"22/2/2022", "2, Jalan Rose", "3, Jalan Jasmine", "TRUE", "TRUE", 50000, 60000, "Parcel", 1000, 10}, {"11/2/2022", "4, Jalan Rose", "5, Jalan Jasmine", "TRUE", "TRUE", 50000, 60000, "Document", 2000, 5}};
        return Arrays.asList(data);
    }


}  
    
//    @Test
//    public void MultiplyTest() {
//        ToTestClass tester = new ToTestClass();
//        assertEquals("Result", result, tester.Order(m1, m2));
//    }
    
    