package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.VegetarianPizza;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author n9740457 and N9499466
 *
 */
public class LogHandler {
	

	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		  try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		    while ((line = reader.readLine()) != null){
		    	
		    	customers.add(createCustomer(line));
		    }	
		    reader.close();
		    
		  }catch(IOException e) {
			 throw new LogHandlerException();
			  
		  }
		  return (ArrayList<Customer>) customers;

		
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		ArrayList<Pizza> Pizzas = new ArrayList<Pizza>();
		
		  try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		    while ((line = reader.readLine()) != null){
		    	
		    	Pizzas.add(createPizza(line));
		    	
		    }
		    reader.close();
		    
		  }catch(IOException e) {
			 throw new LogHandlerException();
			  
		  }
		  return (ArrayList<Pizza>) Pizzas;
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		
		ArrayList<String> splitData = new ArrayList<String>();
		
		
		String name = "";
		String mobileNumber = "";
		String customerCode = "";
		int locationX = 0;
		int locationY = 0;
		
		int nameMin = 1;
		int nameMax = 20;
		int numberLenght = 10;
		char zero = '0';
		int maxDeliveryDistance = 10;
		int resturantLocation = 0;
		Customer newCustomer;
		String[] splitLines = line.split(",");
		splitData = new ArrayList<String>(Arrays.asList(splitLines));
    	
    	name = splitData.get(2);
    	mobileNumber = splitData.get(3);
    	customerCode = splitData.get(4);
    	locationX = Integer.parseInt(splitData.get(5));
    	locationY = Integer.parseInt(splitData.get(6));
    	
    	
    	
    	
    	if ((name.length() >= nameMin) && (name.length() <= nameMax)){
			
			if (name.equals("                    ")){
				
				
				throw new CustomerException();
				
			}
			if ((mobileNumber.charAt(0) == zero) && (mobileNumber.length() == numberLenght)){
				
				if (customerCode.equals("PUC")){
					customerCode = "Pick Up";
					newCustomer = new Customer(name, mobileNumber, locationX, locationY, customerCode) {
						
						@Override
						public double getDeliveryDistance() {
							// TODO Auto-generated method stub
							return 0;
						}
					};
					return newCustomer;
		    	} 
				
				if (((locationX > resturantLocation) && (locationX <= maxDeliveryDistance)) &&
						((locationY > resturantLocation) && (locationY <= maxDeliveryDistance))){
					
					if (customerCode.equals("DNC")){
			    		customerCode = "Drone Delivery";
			    		newCustomer = new Customer(name, mobileNumber, locationX, locationY, customerCode) {
							
							@Override
							public double getDeliveryDistance() {
								// TODO Auto-generated method stub
								return 0;
							}
						};
						return newCustomer;
			    	}else if (customerCode.equals("DVC")){
			    		customerCode = "Driver Delivery";
			    		newCustomer = new Customer(name, mobileNumber, locationX, locationY, customerCode) {
							
							@Override
							public double getDeliveryDistance() {
								// TODO Auto-generated method stub
								return 0;
							}
						};
						return newCustomer;
			    	}else{
			    		
			    		throw new CustomerException();
			    	}
					 
					
					
				}
				
			}
			
		  
		}else {
			
			throw new CustomerException();
		}
    	
    	splitData.clear();
    	
	return null;
	}

	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		
		ArrayList<String> splitData = new ArrayList<String>();
		String[] splitLines = line.split(",");
		splitData = new ArrayList<String>(Arrays.asList(splitLines));
		
		LocalTime orderTime =  LocalTime.parse(splitData.get(0));
		LocalTime deliveryTime = LocalTime.parse(splitData.get(1));
		String pizzaCode = splitData.get(7);
		int quantity = Integer.parseInt(splitData.get(8));
		
	
		String Pizza1 = "PZM";
		String Pizza2 = "PZV";
		String Pizza3 = "PZL";
		int maxQuantity = 10;
		int minQuantity = 1;
		int minLocalTimeHour = 19;
		int maxLocalTimeHour = 23;
		
		if((orderTime.getHour() <= maxLocalTimeHour) && (orderTime.getHour() >= minLocalTimeHour)){
			
			if((quantity >= minQuantity) && (quantity <= maxQuantity)){
				
				if((pizzaCode.equals(Pizza1)) || (pizzaCode.equals(Pizza2)) || (pizzaCode.equals(Pizza3))){
					
					if((pizzaCode.equals(Pizza1))){
						MargheritaPizza newPizza = new MargheritaPizza(quantity, orderTime, deliveryTime);
						return newPizza;
					} else if((pizzaCode.equals(Pizza2))){
						VegetarianPizza newPizza = new VegetarianPizza(quantity, orderTime, deliveryTime);
						return newPizza;
					} else if((pizzaCode.equals(Pizza3))){
						MeatLoversPizza newPizza = new MeatLoversPizza(quantity, orderTime, deliveryTime);
						return newPizza;
					}
					
				} else {
					throw new PizzaException("No such Pizza exists");
				}
				
			} else {
				throw new PizzaException("You must order at least one pizza or less than 10");
			}
			
			
		} else {
			throw new PizzaException("We are unable to deliver at this time. Try Between 7:00pm - 11:00pm");
		}
		
		
		return null;
	}

}
