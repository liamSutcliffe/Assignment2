package asgn2Pizzas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import asgn2Pizzas.PizzaTopping;
import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author n9740457
 *
 */
public abstract class Pizza  {
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 * 
	 */
	
	List<Object> Pizza;
	
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
		
		this.Pizza = new ArrayList<Object>();
		
		int maxQuantity = 10;
		int minQuantity = 1;
		int minLocalTimeHour = 19;
		int maxLocalTimeHour = 23;
		String Pizza1 = "PZM";
		String Pizza2 = "PZV";
		String Pizza3 = "PZL";
		int Pizza1Cost = 8;
		int Pizza2Cost = 10;
		int Pizza3Cost = 12;
		
		// Quantity Check
		
		if((quantity >= minQuantity) && (quantity <= maxQuantity)){
			this.Pizza.add(quantity);
		} else {
			throw new PizzaException("You must order at least one pizza or less than 10");
		}
		
		// Time Check
		
		if((orderTime.getHour() <= maxLocalTimeHour) && (orderTime.getHour() >= minLocalTimeHour)){
			this.Pizza.add(orderTime);	
			this.Pizza.add(deliveryTime);
		} else {
			throw new PizzaException("We are unable to deliver at this time. Try Between 7:00pm - 11:00pm");
		}
		
		// Pizza Type Check
		
		if((type.equals(Pizza1)) || (type.equals(Pizza2)) || (type.equals(Pizza3))){
			this.Pizza.add(type);
		} else {
			throw new PizzaException("No such Pizza exists");
		}
		
		// Price Check 
		
		if((type.equals(Pizza1)) && (price == Pizza1Cost)){
			price *= quantity;
			this.Pizza.add(price);
		} else if ((type.equals(Pizza2)) && (price == Pizza2Cost)) {
			price *= quantity;
			this.Pizza.add(price);
		} else if ((type.equals(Pizza3)) && (price == Pizza3Cost)) {
			price *= quantity;
			this.Pizza.add(price);
		} else {
			throw new PizzaException("The pizza specified does not cost this much");
		}

	}

	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		double cost = 0;
		String Pizza1 = "PZM";
		String Pizza2 = "PZV";
		String Pizza3 = "PZL";
		
		
		if(this.Pizza.get(3) == Pizza1) {
			cost = PizzaTopping.CHEESE.getCost() 
			+ PizzaTopping.TOMATO.getCost();
		} else if (this.Pizza.get(3) == Pizza2) {
			cost = PizzaTopping.CHEESE.getCost() 
			+ PizzaTopping.TOMATO.getCost() 
			+ PizzaTopping.EGGPLANT.getCost() 
			+ PizzaTopping.MUSHROOM.getCost() 
			+ PizzaTopping.CAPSICUM.getCost();
		} else if (this.Pizza.get(3) == Pizza3) {
			cost = PizzaTopping.CHEESE.getCost() 
			+ PizzaTopping.TOMATO.getCost() 
			+ PizzaTopping.BACON.getCost()
			+ PizzaTopping.PEPPERONI.getCost()
			+ PizzaTopping.SALAMI.getCost();
		}
		
		this.Pizza.add(5, cost);	
	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		
		double price = 0;
		
		this.calculateCostPerPizza();
		price = this.Pizza.indexOf(5);
		
		return price;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		
		double price = 0;
		
		if(this.Pizza.get(3).equals("PZM")){
			price = 8.0;
		} else if (this.Pizza.get(3).equals("PZV")){
			price = 10.0;
		} else if (this.Pizza.get(3).equals("PZL")) {
			price = 12.0;
		}
		
		return price;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		double cost = 0;
		int quantity = (int) this.Pizza.get(0);
		
		this.calculateCostPerPizza();
		cost = (double) this.Pizza.get(5);
		cost *= quantity;

		return cost;
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		double price = (double) this.Pizza.get(4);
		return price;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		double profit = 0;
		double cost = this.getOrderCost();
		double price = this.getOrderPrice();
		
		profit = price - cost;
		
		return profit;
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	
	ArrayList<PizzaTopping> Margherita;
	ArrayList<PizzaTopping> MeatLovers;
	ArrayList<PizzaTopping> Vegetarian;
	
	public final boolean containsTopping(PizzaTopping topping){
		boolean bool = false;
		
		Margherita = new ArrayList<PizzaTopping>();
		MeatLovers = new ArrayList<PizzaTopping>();
		Vegetarian = new ArrayList<PizzaTopping>();
		
		Margherita.add(PizzaTopping.CHEESE);
		Margherita.add(PizzaTopping.TOMATO);
		
		MeatLovers.add(PizzaTopping.CHEESE);
		MeatLovers.add(PizzaTopping.TOMATO);
		MeatLovers.add(PizzaTopping.PEPPERONI);
		MeatLovers.add(PizzaTopping.BACON);
		MeatLovers.add(PizzaTopping.SALAMI);
		
		Vegetarian.add(PizzaTopping.CHEESE);
		Vegetarian.add(PizzaTopping.TOMATO);
		Vegetarian.add(PizzaTopping.EGGPLANT);
		Vegetarian.add(PizzaTopping.MUSHROOM);
		Vegetarian.add(PizzaTopping.CAPSICUM);
		
		if(this.Pizza.get(3).equals("PZM")){
			if(Margherita.contains(topping)){
				bool = true;
			}
		} else if (this.Pizza.get(3).equals("PZV")){
			if(Vegetarian.contains(topping)){
				bool = true;
			}
		} else if (this.Pizza.get(3).equals("PZL")) {
			if(MeatLovers.contains(topping)){
				bool = true;
			}
		}
		
		return bool;
	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		 int quantity = (int) this.Pizza.get(0);
		 return quantity;
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		String type = (String) this.Pizza.get(3);
		return type;
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}

	
}
