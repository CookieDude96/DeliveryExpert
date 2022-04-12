package my.com.delivery.order;

import my.com.delivery.user.User;

public class Order {

    //orderID
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
	private DeliveryStaff staff;
	private User user;

    public Order(String sDate1, String Paddress, String Daddress, boolean sameDayDelivery, boolean insurance, int Pcode,
            int Dcode, String item, double weight, double distance) {

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
		this.user = null; // how to attach user to order
        this.staff = null;
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

    // getter for user
    // public getter & setter for delivery stuff
    public DeliveryStaff getStaff(){
        return staff;
    }

    public void setStaff(DeliveryStaff staff){
        this.staff = staff;
    }

    public String toString() {     
        System.out.println("Delivery Date: " + sDate1);
        System.out.println("Pickup Address: " + Paddress);
        System.out.println("Delivery Address: " + Daddress);
        System.out.println("Item Type: " + item);
        System.out.println("Item Weight: " + weight + " g");
        System.out.println("Distance: " + distance + " km");

        if (sameDayDelivery) {
            System.out.println("Same Day Delivery: Yes");
        } else {
            System.out.println("Same Day Delivery: No");
        }

        if (insurance) {
            System.out.println("Insurance: Yes");
        } else {
            System.out.println("Insurance: No");
        }
        System.out.println("Final Charge: RM" + getfinal_total());

		return null;
    }
}