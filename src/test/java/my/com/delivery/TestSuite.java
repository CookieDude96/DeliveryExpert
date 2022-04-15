package my.com.delivery;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import my.com.delivery.deliveryNote.DeliveryNoteTest;
import my.com.delivery.order.CalculationTest;
import my.com.delivery.order.OrderTest;

@RunWith(value = Suite.class)
@SuiteClasses(value = {CalculationTest.class, OrderTest.class, DeliveryNoteTest.class } )

public class TestSuite {

	}
