package my.com.delivery.user;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;



public class UserDAOTest {
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private static final PrintStream originalOut = System.out;
	private static final PrintStream originalErr = System.err;
	
	public static UserDAO userDao;
	public static int counter = 1;
	
	@BeforeClass
	public static void set() {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		userDao = new UserDAO();
		
	}
	@Test
	public void addUserTest() {
		User user = new User("ClaireC", "ClaireC@gmail.com", "0122017978", "Seremban");
		boolean result = userDao.addUser(user);
		if(result) {
			assertEquals(true, result);
		}else {
			String out = "User's email or phone number is already exist.";
			String actual = outContent.toString().replaceAll("\n", "");
			actual = actual.substring(0, actual.length()-1);
			
			//System.out.println("<>"+ actual +"<>");
			assertEquals(out, actual);
		}
		
	}
	@Test
	public void getUserByPhoneNumTest() {
		User user = userDao.getUserByPhoneNum("012345678");
	
		assertEquals("012345678", user.getPhoneNum());
		
	}
	@Test
	public void getAllUserTest() {
		System.out.println("" + userDao.getAllUsers().size());
		assertEquals(13, userDao.getAllUsers().size());
	}
	@AfterClass
	public static void release() {
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	

}
