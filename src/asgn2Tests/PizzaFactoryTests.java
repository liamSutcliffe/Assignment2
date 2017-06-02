package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Exceptions.PizzaException;


/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Liam Doyle N9499466
 * 
 */
public class PizzaFactoryTests {
	
	@Test
	public void PizzaFactoryTest() throws PizzaException{
		Pizza testpizza = PizzaFactory.getPizza("PZM", 2, LocalTime.of(10, 00, 00), LocalTime.of(10, 20, 00));
		
		
	}
	
	@Test (expected = PizzaException.class)
	public void PizzaFactoryException() throws PizzaException{
		Pizza testpizza = PizzaFactory.getPizza("PZQ", 2, LocalTime.of(10, 00, 00), LocalTime.of(10, 20, 00));
			
	}
	
}

