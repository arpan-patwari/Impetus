package com.java.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.java.bo.Actor;

public class LearnPredicatesFunction
{
	Predicate<Integer> predicate = r -> r > 10;

	private static Consumer<Actor> consumer = (r) -> {
		r.setSsn(500);
		r.setName("test name");
	};

	BiConsumer<String, Integer> biConsumer = (a, b) -> a = "Biconsumer param " + a + b;

	Function<Integer, String> function = (a) -> "function return value" + a;

	private static BiFunction<Integer, String, String> biFunction = (a, b) -> "The input params are : " + a + " and  "
			+ b;
	
	private static Supplier<Integer> supplier = () -> 5;

	public static void main(String[] args)
	{
		Actor actor = new Actor();
		consumer.accept(actor);
		System.out.println(actor);

		System.out.println(actor + " " + supplier.get());

		System.out.println(biFunction.apply(1, "arpan"));

		List<Actor> actorList = new ArrayList<Actor>();
		actorList.add(actor);

		System.out.println(
				actorList.stream().filter(x -> Integer.valueOf(1).equals(x.getMovies())).collect(Collectors.toList()));

		// actor.setMovies(2);
		System.out.println(
				actorList.stream().filter(getValueWithoutNPE(actor)).collect(Collectors.toList()));

		System.out.println();
		getDBParam("USERNAME").get();
	}

	/**
	 * 
	 * 
	 * @param actor
	 * @return
	 */
	static Predicate<Actor> getValueWithoutNPE(Actor actor)
	{
		Optional<Integer> opt = Optional.ofNullable(actor.getAge());
		if (opt.isPresent())
		{
			return x -> x.getAge().equals(Integer.valueOf(1));
		}
		return x -> false;
	}

	public static Supplier<String> getDBParam(String paramName)
	{
		if ("USERNAME".equals(paramName))
		{
			return () -> "DB_USERNAME";
		}
		if ("PASSWORD".equals(paramName))
		{
			return () -> "DB_PASSWORD";
		}
		if ("URL".equals(paramName))
		{
			return () -> "DB_URL";
		}
		return null;
	}
}
