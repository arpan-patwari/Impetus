package com.java.streams;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierAndCollectors
{

	public static void main(String[] args)
	{
		biFunction();
	}

	public static void consumer()
	{

		Consumer<Integer> cons = (a) -> System.out.println(a * a);
		cons.accept(2);
	}

	public static void supplier()
	{
		Supplier<Integer> supplier = () -> 5;

		System.out.println(supplier.get());
	}

	public static void biConsumer()
	{
		BiConsumer<Double, Integer> biCOnsumer = (a, b) -> System.out.println(a * b);
		biCOnsumer.accept(5.67, 5);
	}

	public static void predicate()
	{
		Predicate<Integer> pred = (a) -> a > 1;
		System.out.println(pred.test(5));
	}

	public static void function()
	{
		Function<String, String> function = (a) -> "the input is " + a;
		System.out.println(function.apply("arpan"));
	}

	public static void biFunction()
	{
		BiFunction<Integer, String, String> biFunction = (a, b) -> b + a;
		System.out.println(biFunction.apply(1, "My roll no is : "));
	}

}
