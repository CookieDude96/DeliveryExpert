package my.com.delivery.order;

import my.com.delivery.user.User;

public class Order {

    private int orderID;
    private String sDate1;
    private String Paddress;
    private boolean sameDayDelivery;
    private boolean insurance;
    private String Daddress;
    private int Pcode;
    private int Dcode;
    private String item;
    private double weight;
    private double distance;
	private User user;
	private DeliveryStaff staff;

    public Order(int orderID, String sDate1, String Paddress, 
    		String Daddress, boolean sameDayDelivery, boolean insurance, int Pcode,
            int Dcode, String item, double weight, double distance, User user, 
            DeliveryStaff staff) {
    	
    	this.orderID = orderID;
        this.sDate1 = sDate1;
        this.Paddress = Paddress;
        this.Daddress = Daddress;
        this.sameDayDelivery = sameDayDelivery;
        this.insurance = insurance;
        this.Pcode = Pcode;
        this.Dcode = Dcode;
        this.item = item;
        this.weight = weight;
        this.distance = distance;
		this.user = user;
		this.staff = staff;
    }
    
    public int getOrderID() {
		return orderID;
	}

    public String getsDate1() {
        return sDate1;
    }

    public String getPaddress() {
        return Paddress;
    }

    public String getDaddress() {
        return Daddress;
    }

    public boolean getSameDayDelivery() {
        return sameDayDelivery;
    }

    public boolean getInsurance() {
        return insurance;
    }

    public int getPcode() {
        return Pcode;
    }

    public int getDcode() {
        return Dcode;
    }

    public String getItem() {
        return item;
    }

    public double getweight() {
        return weight;
    }

    public double getdistance() {
        return distance;
    }

    public double getfinal_total() {
        Calculation calc = new Calculation(item, distance, weight, sameDayDelivery, insurance);
        double finalCharge = calc.getCharge();

        return finalCharge;
    }

    public User getUser(){
        return user;
    }
    
    public DeliveryStaff getStaff() {
    	return staff;
    }

    public String toString() {     
    	return orderID + ", " + sDate1 + ", " +  Paddress + ", " 
    			+ Daddress + ", " + sameDayDelivery + ", " 
    			+ insurance + ", " + Pcode + ", " + Dcode + ", " 
    			+ item + ", " + weight + ", " + distance + ", " 
				+ user.getPhoneNum() + ", " + staff.getDeliveryStaffNum();
    }

}