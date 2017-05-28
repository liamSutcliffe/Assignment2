package asgn2Tests;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import asgn2Customers.Customer;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.*;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	
	ArrayList<Customer> customerstest;
	ArrayList<Pizza> pizzastest;
	
	@Before
	public void PizzaRestaurantTest() {
		customerstest = new ArrayList<Customer>();
		pizzastest = new ArrayList<Pizza>();
		
	}
	
	@Before
	public void pizzaToTest() throws PizzaException{
		MeatLoversPizza pizza = new MeatLoversPizza(5, LocalTime.of(10, 10, 00), LocalTime.of(10, 02, 00));
		
	}
	
	@Test (expected = CustomerException.class)
	public void processLogLogHandlerExceptionTest() throws CustomerException, PizzaException, LogHandlerException{
		.processLog("");
		
	}

	@Test
	public void getCustomerByIndexTest() throws CustomerException{
	 asserEquals(customertest, g
	}
	
	@Test
	public void getPizzaByIndexTest() throws PizzaException{
		
		// TO DO
	}
	
	@Test
	public void getNumPizzaOrdersTest(){
		// TO DO
	}

	@Test
	public void getNumCustomerOrdersTest(){
		// TO DO
	}

			
	
	@Test
	public void getTotalDeliveryDistanceTest(){
		// TO DO
	}

	@Test
	public void getTotalProfitTest(){
		// TO DO
	}
	
	@Test
	public void resetDetailsTest(){
		// TO DO
	}
	
	// TO DO
}
