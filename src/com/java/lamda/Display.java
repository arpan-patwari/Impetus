package com.java.lamda;

@FunctionalInterface
public interface Display
{

	// abstract public void displayBalance(Integer one, Integer two);

	abstract public Integer toCalculation(Integer one, Integer two);

	default void defMethod()
	{
		System.out.println("This is a default method");
	}

	default void defMethod1()
	{
		System.out.println("This is a default method");
	}

	default void defMethod2()
	{
		System.out.println("This is a default method");
	}
	
	static void staticMethod()
	{
		System.out.println("This is a static method");
	}

	static void staticMethod1()
	{
		System.out.println("This is a static method");
	}

	static void staticMethod2()
	{
		System.out.println("This is a static method");
	}
}
