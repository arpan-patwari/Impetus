package com.java.designpattern.decorator;

public class PizzaDecorator implements Pizza
{

	Pizza pizza;

	public PizzaDecorator(Pizza pizza)
	{
		this.pizza = pizza;
	}

	@Override
	public String decorate()
	{
		return pizza.decorate();
	}
}
