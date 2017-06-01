package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;



/**
 * 
 *  A class that represents a margherita pizza made at the Pizza Palace restaurant. 
 *  The margherita pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Person A
 *
 */
public class MargheritaPizza extends Pizza {

	
	/**
	 * 
	 *  This class represents a margherita pizza made at the  Pizza Palace restaurant.   The margherita pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
	 * <P>PRE: TRUE
	 * <P>POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public MargheritaPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		super(quantity, orderTime, deliveryTime, "Margherita", 8.00);
		int maxQuantity = 10;
		int minQuantity = 1;
		int minLocalTimeHour = 19;
		int maxLocalTimeHour = 23;
		
		// Quantity Check
		
		if((quantity <= minQuantity) && (quantity >= maxQuantity)){
			this.Pizza.add(quantity);
		} else {
			throw new PizzaException("You must ");
		}
		
		// Time Check
		
		if((orderTime.getHour() < maxLocalTimeHour) && (orderTime.getHour() > minLocalTimeHour)){
			this.Pizza.add(orderTime);	
			this.Pizza.add(deliveryTime);
		} else {
			throw new PizzaException("We are unable to deliver at this time. Try Between 7:00pm - 11:00pm");
		}
		
		
	}

}
