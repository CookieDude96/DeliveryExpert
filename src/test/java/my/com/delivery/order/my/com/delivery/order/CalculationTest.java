package my.com.delivery.order;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalculationTest{

    @Test
	@Parameters(method = "getParamCalculation")
    public void testCalculation(String item_type, double distance, 
			double weight, boolean sameDayDelivery, 
			boolean insurance, double expectedResult){
        
        try{
        Calculation calculation = new Calculation(item_type, distance, weight, sameDayDelivery, insurance);
        assertEquals("Fail", expectedResult ,calculation.getCharge(), 0.01);

        }
           catch(IllegalArgumentException ex){
			
			throw new IllegalArgumentException("Error. File contain invalid data type: Please ensure that data in file is in correct format");
		}
    }

    @Test(expected = IllegalArgumentException.class) 
	@Parameters(method = "getParamInvalidCalculation")
    public void testInvalidCalculation(String item_type, double distance, 
			double weight, boolean sameDayDelivery, 
			boolean insurance){
        
        try{
            Calculation calculation = new Calculation(item_type, distance, weight, sameDayDelivery, insurance);
            calculation.getCharge();
        }
           catch(IllegalArgumentException ex){
			
			throw new IllegalArgumentException("Error. File contain invalid data type: Please ensure that data in file is in correct format");
		}
    }

    private Object[] getParamCalculation() {
		File file = new File ("ParamCalculation.txt");
		String [] input;
		
		ArrayList<Object> params = new ArrayList<Object>();
		
		try {
			
			Scanner inputFile = new Scanner(file);
			while(inputFile.hasNext()) {
				
				ArrayList<Object> param = new ArrayList<Object>();
				
				String line = inputFile.nextLine();
				//Split the variables
				input = line.split(";");
				param.add(input[0]); //item_type
				param.add(Double.parseDouble(input[1])); // item_type
				param.add(Double.parseDouble(input[2]));// distance
				param.add(Boolean.parseBoolean(input[3]));// weight
                param.add(Boolean.parseBoolean(input[4]));// insurance
				param.add(Double.parseDouble(input[5])); // expected result

				params.add(param.toArray());
			}
			inputFile.close();
			
		}
		catch(FileNotFoundException ex){
			System.out.println("ParamCalculationInvalid.txt not found");
		}
		return params.toArray();	
	
	}

    private Object[] getParamInvalidCalculation() {
		return new Object[] {
					new Object[] {"document", -10, 500, true, true},
					new Object[] {"document", 50, -50, true, true},
					new Object[] {"document", "a" , true, true},
					new Object[] {"document", 50 , "a", true,true},
					new Object[] {"document", 50 , 500, "a", true},
					new Object[] {"document", 50 , 500, true, "a"},
					new Object[] {" ", 50 , 500, true, true},
					new Object[] {"document", null , 500, true, true},
					new Object[] {"document", 50 , null, true, true},
					new Object[] {"document", 50 , 500, null, true},
					new Object[] {"document", 50 , 500, true, null},
					new Object[] {"item", 50 , 500, true, true},
			};
}
}