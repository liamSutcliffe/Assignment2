package asgn2Tests;

import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author n9740457
 */
public class RestaurantCustomerTests {
	PizzaRestaurant testResturant;
	ArrayList<Customer> customerstest;
	
	DroneDeliveryCustomer customer1;
	DroneDeliveryCustomer customer2;
	
	@Before
	public void customerToTest() throws PizzaException, CustomerException, LogHandlerException{
		
		
		
		testResturant = new PizzaRestaurant();
		customerstest = new ArrayList<Customer>();
		
		testResturant.processLog("21:17:00,21:27:00,Emma Brown,0602547760,DVC,-1,0,PZV,5");
		
		customer1 = new DroneDeliveryCustomer("liam","0488444869", 5,5);
		customer2 = new DroneDeliveryCustomer("liamS","0488444869", 4,4);
		
		customerstest.add(customer1);
		customerstest.add(customer2);
	}
	
	@Test (expected = LogHandlerException.class)
	public void processLogLogHandlerExceptionTest() throws CustomerException, PizzaException, LogHandlerException{
		testResturant.processLog("");	
	}
	
	@Test
	public void getCustomerByIndexTest(){
	 assertEquals(customer1, customerstest.get(0));
	}
	
	@Test (expected = CustomerException.class)
	public void getCustomerByIndexEsceptionTest() throws CustomerException{
		customerstest.get(1);
	}
	
	@Test
	public void getNumCustomerOrdersTest(){
		assertEquals(1, testResturant.getNumCustomerOrders());
	}
	
	@Test
	public void resetDetailsTest(){
		testResturant.resetDetails();
		assertEquals(0, customerstest.size());	
	}
}
