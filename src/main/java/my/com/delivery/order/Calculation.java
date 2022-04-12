package my.com.delivery.order;

public class Calculation {

	private String item_type;
	private double weight;
	private double distance;
	private double charge;
	private boolean sameDayDelivery;
	private boolean insurance;
	
	public Calculation(String item_type, double distance, double weight,boolean sameDayDelivery,boolean insurance){
		
		this.item_type = item_type;
		this.distance = distance;
		this.weight = weight;
		this.sameDayDelivery = sameDayDelivery;
		this.insurance = insurance;
	}
	
	public double getCharge()
	{	
		if(item_type.equals("Document")) {
			
			if(weight >= 0 && weight < 300) {
				charge = 3.00;
				
			}
			else if(weight >=300 && weight <= 1000)
			{
				if(distance < 10)
					charge = 4.00;
				else if(distance >= 10 && distance <= 30)
					charge = 8.00;
				else 
					charge = 10.00;
			}
			else if(weight > 1000 && weight <= 3000)
			{
				if(distance < 10)
					charge = 4.00;
				else if(distance >= 10 && distance <= 30)
					charge = 8.00;
				else 
					charge = 10.00;
			}
			
			else if(weight > 3000 && weight <= 5000)
			{
				if(distance < 10)
					charge = 12.00;
				else if(distance >= 10 && distance <= 30)
					charge = 18.00;
				else 
					charge = 25.00;
			}
			else
			{
				if(distance < 10)
					charge = 25.00;
				else if(distance >= 10 && distance <= 30)
					charge = 30.00;
				else 
					charge = 35.00;
			}
	}
		else if(item_type.equals("Parcel"))
		{
			if(weight >= 0 && weight <= 1000)
			{
				if(distance < 10)
					charge = 5.00;
				else if(distance >= 10 && distance <= 30)
					charge = 8.00;
				else 
					charge = 10.00;
			}
			else if(weight > 1000 && weight <= 2000 )
			{
				if(distance < 10)
					charge = 15.00;
				else if(distance >= 10 && distance <= 30)
					charge = 18.00;
				else 
					charge = 25.00;
			}
			else if(weight > 2000 && weight <= 3000 )
			{
				if(distance < 10)
					charge = 23.00;
				else if(distance >= 10 && distance <= 30)
					charge = 28.00;
				else 
					charge = 35.00;
			}
			else if(weight > 3000 && weight <= 4000 )
			{
				if(distance < 10)
					charge = 35.00;
				else if(distance >= 10 && distance <= 30)
					charge = 40.00;
				else 
					charge = 50.00;
			}
			else
			{
				if(distance < 10)
					charge = 45.00;
				else if(distance >= 10 && distance <= 30)
					charge = 50.00;
				else 
					charge = 60.00;
			}
		}

		if(this.sameDayDelivery)
		{
			charge += 10.00;
		}
		
		if(this.insurance)
		{
			charge += 15.00;
		}
		
		return charge;
	}
	
	public String getItem_type()
	{
		return item_type;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getDistance()
	{
		return distance;
	}
	
	public void getAdditionalCharges()
	{
		System.out.println("Same Day delivery : " + "RM10.00\nInsurance: RM15.00");
	}
}