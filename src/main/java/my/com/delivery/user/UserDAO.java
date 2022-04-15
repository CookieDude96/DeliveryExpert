package my.com.delivery.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDAO {

	List<User> userList = new ArrayList<>();

	public boolean addUser(User user) {
		boolean result = false;
		if (userList.isEmpty()) {
			userList = getAllUsers();
		}

		for (User existingUser : userList) {
			if (existingUser.getEmail().equals(user.getEmail())
					|| existingUser.getPhoneNum().equals(user.getPhoneNum())) {
				System.out.println("User's email or phone number is already exist.");
				return false;
			}
		}

		try {
			FileOutputStream f = new FileOutputStream(new File("users.txt"), true);

			f.write(user.toString().getBytes());
			f.write("\n".getBytes());

			f.close();
			result = true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public User getUserByPhoneNum(String phoneNum) {

		for (User user : getAllUsers()) {
			if (user.getPhoneNum().equals(phoneNum)) {
				return user;
			}
		}

		return null;
	}

	public void showAllUsers() {
		AtomicInteger counter = new AtomicInteger(1);
		if (userList.isEmpty()) {
			userList = getAllUsers();
		}

		int len = userList.size();
		if (len == 0) {
			System.out.println("No existing users");
		}

		for (User user : userList) {
			System.out.println("");
			System.out.println(counter.get() + ". | " + user.getName() + " | " + user.getEmail() + " | "
					+ user.getPhoneNum() + " | " + user.getAddress());

			if (counter.get() != len) {
				System.out.println("--------------------------------------------------");

			}
			counter.getAndIncrement();
		}

	}

	public List<User> getAllUsers() {

		try {
			FileInputStream fi = new FileInputStream(new File("users.txt"));
			// ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			try (BufferedReader br = new BufferedReader(new InputStreamReader(fi))) {
				String line;
				while ((line = br.readLine()) != null) {
					// resultStringBuilder.append(line).append("\n");
					String[] collectData = line.split(";");
					User obj = new User(collectData[0].trim(), collectData[1].trim(), collectData[2].trim(),
							collectData[3].trim());
					userList.add(obj);
				}

			}
			// userList = (List <User>) oi.readObject();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

}
