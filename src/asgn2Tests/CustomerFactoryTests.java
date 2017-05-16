package asgn2Tests;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Liam Sutcliffe - n9740457
 *
 */
public class CustomerFactoryTests {
	
	// General Tests

	@Test
	public void CustomerFactoryTest1() throws CustomerException{
		Customer testpizza = CustomerFactory.getCustomer("PUC", "Liam", "048844869", 3, 3);	
	}
	
	@Test
	public void CustomerFactoryTest2() throws CustomerException{
		Customer testpizza = CustomerFactory.getCustomer("DNC", "Liam", "048844869", 3, 3);	
	}
	
	@Test
	public void CustomerFactoryTest3() throws CustomerException{
		Customer testpizza = CustomerFactory.getCustomer("DVC", "Liam", "048844869", 3, 3);	
	}
	
	// Exception Tests
	
	@Test (expected = CustomerException.class)
	public void PizzaFactoryException() throws CustomerException{
		Customer testpizza = CustomerFactory.getCustomer("DNF", "Liam", "048844869", 3, 3);	
	}
	
	
}
