package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Liam Sutcliffe = n9740457
 * 
 *
 */
public class CustomerTests {
	
	// General Testing
	
	// PickUpCustomer Tests
	
	@Test
	public void CustomerNameTest() throws CustomerException {
		Customer nameTest1 = new PickUpCustomer("Liam","0488444869",3,3);
		assertEquals("Liam", nameTest1.getName());
	}
	
	@Test
	public void CustomerMobileTest() throws CustomerException {
		Customer mobileTest1 = new PickUpCustomer("Liam","0488444869",3,3);
		assertEquals("0488444869", mobileTest1.getMobileNumber());
	}
	
	@Test
	public void CustomerLocationTest1() throws CustomerException {
		Customer locationTest1 = new PickUpCustomer("Liam","0488444869",3,4);
		assertEquals(3, locationTest1.getLocationX());
	}
	
	@Test
	public void CustomerLocationTest2() throws CustomerException {
		Customer locationTest2 = new PickUpCustomer("Liam","0488444869",3,4);
		assertEquals(4, locationTest2.getLocationY());
	}
	
	// Exception Tests
	
	// PickUpCustomer Tests
	
	@Test (expected = CustomerException.class)
	public void CustomerPickUpExceptionNameTest1() throws CustomerException {
		Customer nameTest1 = new PickUpCustomer("","0488444869",3,3);
	}
	
	@Test (expected = CustomerException.class)
	public void CustomerPickUpExceptionNameTest2() throws CustomerException {
		Customer nameTest2 = new PickUpCustomer("MYNAMEISLONGERTHANTHEREQUIREDAMOUNT","0488444869",3,3);
	}
	
	@Test (expected = CustomerException.class)
	public void CustomerPickUpExceptionDistanceTest1() throws CustomerException {
		Customer distanceTest1 = new PickUpCustomer("Liam","0488444869",11,11);
	}
	
	@Test (expected = CustomerException.class)
	public void CustomerPickUpExceptionDistanceTest2() throws CustomerException {
		Customer distanceTest1 = new PickUpCustomer("Liam","0488444869",-11,-11);
	}
	
	@Test (expected = CustomerException.class)
	public void CustomerPickUpExceptionMobileTest1() throws CustomerException {
		Customer mobileTest1 = new PickUpCustomer("Liam","1111",3,3);
	}
	
	@Test (expected = CustomerException.class)
	public void CustomerPickUpExceptionMobileTest2() throws CustomerException {
		Customer mobileTest2 = new PickUpCustomer("Liam","01234567896",3,3);
	}
	
	// DriverDelivery Tests
	
	@Test (expected = CustomerException.class)
	public void DriverDeliveryExceptionNameTest1() throws CustomerException {
		Customer nameTest1 = new DriverDeliveryCustomer("","0488444869",3,3);
	}
	
	@Test (expected = CustomerException.class)
	public void DriverDeliveryExceptionNameTest2() throws CustomerException {
		Customer nameTest2 = new DriverDeliveryCustomer("MYNAMEISLONGERTHANTHEREQUIREDAMOUNT","0488444869",3,3);
	}
	
	@Test (expected = CustomerException.class)
	public void DriverDeliveryExceptionDistanceTest1() throws CustomerException {
		Customer distanceTest1 = new DriverDeliveryCustomer("Liam","0488444869",11,11);
	}
	
	@Test (expected = CustomerException.class)
	public void DriverDeliveryExceptionDistanceTest2() throws CustomerException {
		Customer distanceTest1 = new DriverDeliveryCustomer("Liam","0488444869",-11,-11);
	}
	
	@Test (expected = CustomerException.class)
	public void DriverDeliveryExceptionMobileTest1() throws CustomerException {
		Customer mobileTest1 = new DriverDeliveryCustomer("Liam","1111",3,3);
	}
	
	@Test (expected = CustomerException.class)
	public void DriverDeliveryExceptionMobileTest2() throws CustomerException {
		Customer mobileTest2 = new DriverDeliveryCustomer("Liam","01234567896",3,3);
	}
	
	// DroneDelivery Tests
	
	@Test (expected = CustomerException.class)
	public void DroneDeliveryExceptionNameTest1() throws CustomerException {
		Customer nameTest1 = new DroneDeliveryCustomer("","0488444869",3,3);
	}
	
	@Test (expected = CustomerException.class)
	public void DroneDeliveryExceptionNameTest2() throws CustomerException {
		Customer nameTest2 = new DroneDeliveryCustomer("MYNAMEISLONGERTHANTHEREQUIREDAMOUNT","0488444869",3,3);
	}
	
	@Test (expected = CustomerException.class)
	public void DroneDeliveryExceptionDistanceTest1() throws CustomerException {
		Customer distanceTest1 = new DroneDeliveryCustomer("Liam","0488444869",11,11);
	}
	
	@Test (expected = CustomerException.class)
	public void DroneDeliveryExceptionDistanceTest2() throws CustomerException {
		Customer distanceTest1 = new DroneDeliveryCustomer("Liam","0488444869",-11,-11);
	}
	
	@Test (expected = CustomerException.class)
	public void DroneDeliveryExceptionMobileTest1() throws CustomerException {
		Customer mobileTest1 = new DroneDeliveryCustomer("Liam","1111",3,3);
	}
	
	@Test (expected = CustomerException.class)
	public void DroneDeliveryExceptionMobileTest2() throws CustomerException {
		Customer mobileTest2 = new DroneDeliveryCustomer("Liam","01234567896",3,3);
	}
}
