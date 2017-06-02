package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author n9740457
 */
public class LogHandlerCustomerTests {
	
	// General Tests 
	
	@Test
	public void LogHandlerNameTest() throws CustomerException, LogHandlerException {
	Customer testCustomer = LogHandler.createCustomer("19:00:00,19:20:00,Liam,0123456789,DNC,3,3,PZV,2");
	assertEquals("PZV", testCustomer.getName());
	}
	
	@Test
	public void LogHandlerLocationTest1() throws CustomerException, LogHandlerException {
	Customer testCustomer = LogHandler.createCustomer("19:00:00,19:20:00,Liam,0123456789,DNC,3,3,PZV,2");
	assertEquals(3, testCustomer.getLocationX());
	}
	
	@Test
	public void LogHandlerLocationTest2() throws CustomerException, LogHandlerException {
	Customer testCustomer = LogHandler.createCustomer("19:00:00,19:20:00,Liam,0123456789,DNC,3,3,PZV,2");
	assertEquals(3, testCustomer.getLocationY());
	}
	
	@Test
	public void LogHandlerTypeTest() throws CustomerException, LogHandlerException {
	Customer testCustomer = LogHandler.createCustomer("19:00:00,19:20:00,Liam,0123456789,DNC,3,3,PZV,2");
	assertEquals("DNC", testCustomer.getCustomerType());
	}
	
	@Test
	public void LogHandlerMobileTest() throws CustomerException, LogHandlerException {
	Customer testCustomer = LogHandler.createCustomer("19:00:00,19:20:00,Liam,0123456789,DNC,3,3,PZV,2");
	assertEquals("0123456789", testCustomer.getMobileNumber());
	}
	
	// Exception Testing 
	
	@Test (expected = CustomerException.class)
	public void testCustomerExceptionTime () throws CustomerException, LogHandlerException {
		Customer testCustomer = LogHandler.createCustomer("ll,19:20:00,Liam,0123456789,DNC,3,3,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void testCustomerExceptionDelCode () throws CustomerException, LogHandlerException {
		Customer testCustomer = LogHandler.createCustomer("19:00:00,19:20:00,Liam,0123456789,DNsdsdC,3,3,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void testCustomerExceptionPizzaCode () throws CustomerException, LogHandlerException {
		Customer testCustomer = LogHandler.createCustomer("19:00:00,19:20:00,Liam,0123456789,DNC,3,3,PsdsdZV,2");	
	}
	
	@Test (expected = CustomerException.class)
	public void testCustomerExceptionLocation () throws CustomerException, LogHandlerException {
		Customer testCustomer = LogHandler.createCustomer("19:00:00,19:20:00,Liam,0123456789,DNC,34,3,PZV,2");	
	}
	
	@Test (expected = CustomerException.class)
	public void testCustomerExceptionQuantity () throws CustomerException, LogHandlerException {
		Customer testCustomer = LogHandler.createCustomer("19:00:00,19:20:00,Liam,0123456789,DNC,3,3,PZV,300");	
	}
	
	@Test (expected = CustomerException.class)
	public void testLogHandlerException () throws CustomerException, LogHandlerException {
		Customer testCustomer = LogHandler.createCustomer("");	
	}

	
	
}
