package com.java.basics;

@FunctionalInterface
public interface SuperInterface
{
	default void defautMethod()
	{
		System.out.println("SuperInterface :- Inside default method");
	}
	
	default void defautMethod1321313()
	{
		System.out.println("SuperInterface :- Inside defautMethod1321313 method");
	}

	void abstractMethod();
	
	static void staticMethod()
	{
		System.out.println("SuperInterface :- This is a static method");
	}

	static void staticMethod1321313()
	{
		System.out.println("SuperInterface :- This is a staticMethod1321313 method");
	}
}
