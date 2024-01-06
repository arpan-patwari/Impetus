package com.java.designpattern.decorator;

public class SausageDecorator extends PizzaDecorator
{
	private Pizza pizza;

	public String decorate()
	{
		return pizza.decorate() + " sausage";
	}

	public SausageDecorator(Pizza pizza)
	{
		super(pizza);
		this.pizza = pizza;
	}
}
