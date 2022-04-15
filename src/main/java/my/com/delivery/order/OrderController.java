package my.com.delivery.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OrderController {
    Scanner scanner = new Scanner(System.in);

    public String getDeliveryDate(String date) {
        // Enter date and validate the data format

        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            Date today = new Date();

            if (date1.compareTo(today) < 0) {
                System.out.println("Delivery Date must be after today.");

                return "";
            }

        } catch (Exception e) {

        }

        return date;
    }

    public String getPickUpAddress(String Paddress) {
        // Enter pick up address

        return Paddress;
    }

    public int getPCode(int Pcode) {
        // Enter pickup pos code and validate the pos code

        if (Pcode <= 40000 || Pcode >= 68100) {
        	System.out.println(Pcode + " is an invalid postcode. Please try again.");
        	return (Integer) null;
        }         

        return Pcode;
    }

    public String getDeliveryAddress(String Daddress) {
        // Enter delivery address

        return Daddress;
    }

    public int getDCode(int Dcode) {
        // Enter delivery pos code and validate the pos code

        if (Dcode <= 40000 || Dcode >= 68100) {
        	System.out.println(Dcode + " is an invalid postcode. Please try again.");
        	return (Integer) null;
        }
                 
        return Dcode;
    }

    public String getItem(int itemChoice) {
        // Enter 1 or 2 to choose Parcel or Document
        String item = null;

        if (itemChoice == 1) {
            System.out.println("You have selected Parcel.");
            item = "Parcel";

        } else if (itemChoice == 2) {
            System.out.println("You have selected Document.");
            item = "Document";

        } else {
            System.out.println("Invalid Input. Please try again.");
        }
        return item;
    }

    public double getWeight(double weight) {
        // Enter the item weight in grams


        if (weight < 0) {
            System.out.println("Weight must be more than 0 gram.");
            return (Double) null;
        }
        return weight;
    }

    public double getDistance(double distance) {
        // Enter distance and need to be limit to 100km

        if (distance > 100)
            System.out.println("Exceed the limit of 100 km. Please try again.");

        else
            return distance;

        return distance;
    }

    public boolean getSameDayDelivery(String decision1) {
        // Whether want to add same day delivery fee
        boolean sameDayDelivery = false;

        if (decision1.equals("y")) {
            decision1 = "Yes";
            sameDayDelivery = true;
        }

        else if (decision1.equals("n")) {
            decision1 = "No";
        }

        else {
            System.out.println("Invalid Input. Please try again.");
            return (Boolean) null;
        }

        return sameDayDelivery;
    }

    public boolean getInsurance(String decision2) {
        // Whether want to add delivery insurance
        boolean insurance = false;

        if (decision2.equals("y")) {
            decision2 = "Yes";
            insurance = true;
        }

        else if (decision2.equals("n")) {
            decision2 = "No";
        }

        else {
            System.out.println("Invalid Input. Please try again.");
            return (Boolean) null;
        }

        return insurance;
    }
}
