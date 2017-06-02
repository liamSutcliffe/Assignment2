package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;
import asgn2Restaurant.PizzaRestaurant;
import asgn2Exceptions.PizzaException;
import asgn2Exceptions.LogHandlerException;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Liam Doyle N9499466
* 
*/
public class LogHandlerPizzaTests {
	
	
	@Test
	public void LogHandlerPizzaValid() throws PizzaException, LogHandlerException {
	Pizza testpizza = LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	assertEquals("PZV", testpizza.getPizzaType());
	}
	
	@Test (expected = PizzaException.class)
	public void testPizzaExceptionSemantic () throws PizzaException, LogHandlerException {
		Pizza testpizzaSemantic = LogHandler.createPizza("kk,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}
	
	@Test (expected = PizzaException.class)
	public void testPizzaExceptionPizzaCode() throws PizzaException, LogHandlerException {
		Pizza testpizzapizzacode = LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZ10,2");
	}
	
	@Test (expected = PizzaException.class)
	public void testPizzaExceptionCustomerCode() throws PizzaException, LogHandlerException {
		Pizza testpizzacustomer = LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,REC,5,5,PZV,2");
	}
	
	@Test (expected = PizzaException.class)
	public void testPizzaExceptionLocation() throws PizzaException, LogHandlerException {
		Pizza testpizzalocation = LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,111,5,PZV,2");
	}
	
	@Test (expected = PizzaException.class)
	public void testPizzaExceptionQuantity() throws PizzaException, LogHandlerException {
		Pizza testpizzaquantity = LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,200");
	}
	
	@Test (expected = LogHandlerException.class)
	public void testPizzaException() throws PizzaException, LogHandlerException {
		Pizza testpizzaLog = LogHandler.createPizza("");
		assertEquals("PZV", testpizzaLog.getPizzaType());
	}
		

}
