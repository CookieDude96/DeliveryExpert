package my.com.delivery.order;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

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
    
    