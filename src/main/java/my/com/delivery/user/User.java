package my.com.delivery.user;

import java.io.Serializable;

public class User implements Serializable{ 
	//when write obj/ read into file
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String phoneNum;
	private String address;
	
	
	public User(String name, String email, String phoneNum, String address) {
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	public User() {
		
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	
	//source > toString
	@Override
	public String toString() {
		return name + ", " + email + ", " + phoneNum + ", " + address;
	}
	
}
