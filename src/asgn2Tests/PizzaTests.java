package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import asgn2Exceptions.PizzaException;
import asgn2Pizzas.*;
import java.time.LocalTime;


/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	
	@Test (expected  = PizzaException.class)
	public void PizzaExceptionTest() throws PizzaException {
		
		Pizza meatexceptiontest = new asgn2Pizzas.MeatLoversPizza(ten, LocalTime.of(10, 00, 00), LocalTime.of(10, 20, 00));
		
	}
	
	@Test (expected  = PizzaException.class)
	public void PizzaExceptionTimeTest() throws PizzaException {
		
		Pizza meattimetest = new asgn2Pizzas.MeatLoversPizza(1, LocalTime.of(10, 00, 00), LocalTime.of(10, 02, 00));
		
	}
	
	@Test 
	public void PizzaMargheritaTest() throws PizzaException {
		
		Pizza margheritatest = new asgn2Pizzas.MargheritaPizza(1, LocalTime.of(10, 00, 00), LocalTime.of(10, 20, 00));
		assertEquals("Margherita", margheritatest.getPizzaType());
	}
	
	
	@Test 
	public void PizzaMeatTest() throws PizzaException {
		
		Pizza meattest = new asgn2Pizzas.MeatLoversPizza(1, LocalTime.of(10, 00, 00), LocalTime.of(10, 20, 00));
		assertEquals("Meat Lovers", meattest.getPizzaType());
	}
	
	@Test
	public void PizzaVegTest() throws PizzaException {
		
		Pizza vegtest = new asgn2Pizzas.VegetarianPizza(1, LocalTime.of(10, 00, 00), LocalTime.of(10, 20, 00));
		assertEquals("Vegetarian", vegtest.getPizzaType());
	}
	
	// TO DO
}
