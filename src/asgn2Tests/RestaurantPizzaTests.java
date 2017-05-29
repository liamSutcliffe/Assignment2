package asgn2Tests;

import static org.junit.Assert.*;

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
	
	PizzaRestaurant testResturant;
	ArrayList<Customer> customerstest;
	ArrayList<Pizza> pizzastest;
	Customer cust = null;
	MeatLoversPizza pizza;
	MeatLoversPizza pizza2;
	
	@Before
	public void pizzaToTest() throws PizzaException{
		testResturant = new PizzaRestaurant();
		customerstest = new ArrayList<Customer>();
		pizzastest = new ArrayList<Pizza>();
		
		pizza = new MeatLoversPizza(5, LocalTime.of(10, 10, 00), LocalTime.of(10, 20, 00));
		pizza2 = new MeatLoversPizza(5, LocalTime.of(10, 00, 00), LocalTime.of(10, 10, 00));
		
		pizzastest.add(pizza);
		pizzastest.add(pizza2);
		
		
		try {
			cust = new Customer("name", "", 1, 2, " ") {
				
				@Override
				public double getDeliveryDistance() {
					// TODO Auto-generated method stub
					return 0;
				}
			};
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerstest.add(cust);
		
		
		
	}
	
	
	@Test (expected = LogHandlerException.class)
	public void processLogLogHandlerExceptionTest() throws CustomerException, PizzaException, LogHandlerException{
		testResturant.processLog("");
		
	}

	@Test
	public void getCustomerByIndexTest(){
	 assertEquals(cust, customerstest.get(0));
	}
	
	@Test (expected = CustomerException.class)
	public void getCustomerByIndexEsceptionTest() throws CustomerException{
		customerstest.get(1);
	}
	
	@Test (expected = PizzaException.class)
	public void getPizzaByIndexExceptionTest() throws PizzaException{
		pizzastest.get(4);
		
	}
	
	@Test 
	public void getPizzaByIndexTest(){
		assertEquals(pizza2, pizzastest.get(1));
		
	}
	
	@Test 
	public void getNumPizzaOrdersTest(){
		pizzastest.remove(1);
		assertEquals(1,pizzastest.size());
	}
	
	@Test
	public void getNumPizzaOrdersTest2(){
		assertEquals(2, pizzastest.size());
	}

	@Test
	public void getNumCustomerOrdersTest(){
		assertEquals(1, testResturant.getNumCustomerOrders());
	}
	
	
	
	@Test
	public void getTotalDeliveryDistanceTest(){
		assertEquals(0, cust.getDeliveryDistance());
	}

	@Test
	public void getTotalProfitTest(){
		assertEquals(0, testResturant.getTotalProfit());
	}
	
	@Test
	public void resetDetailsTest(){
		testResturant.resetDetails();
		assertEquals(0, customerstest.size());
		
	}
	
}
