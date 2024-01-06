package com.java.designpattern.decorator;

public class CheeseDecorator extends PizzaDecorator
{
	private Pizza pizza;

	public String decorate()
	{
		return super.decorate() + " cheese";
	}

	public CheeseDecorator(Pizza pizza)
	{
		super(pizza);
		this.pizza = pizza;
	}
}
