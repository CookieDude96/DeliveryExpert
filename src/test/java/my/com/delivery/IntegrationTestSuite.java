package my.com.delivery;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import my.com.delivery.menu.OrderIntegrationTest;
import my.com.delivery.user.UserIntegrationTest;

@RunWith(value = Suite.class)
@SuiteClasses(value = {UserIntegrationTest.class,OrderIntegrationTest.class} )
public class IntegrationTestSuite {


}
