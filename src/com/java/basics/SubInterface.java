package com.java.basics;

public interface SubInterface
{
	default void defautMethod()
	{
		System.out.println("SubInterface :- Inside  default method");
	}

	void abstractMethod();

	static void staticMethod()
	{
		System.out.println("SubInterface :- This is a static method");
	}
}
