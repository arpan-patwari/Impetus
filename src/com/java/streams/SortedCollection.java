package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java.bo.Actor;
import com.java.bo.PracticeData;

public class SortedCollection
{
	public static void main(String[] args)
	{
		// new SortedCollection().actor_with_least_movies();
		// new SortedCollection().actor_name_list_with__movies_desc();
		// main1();
		// new
		// SortedCollection().actor_name_list_with_movies_desc_using_comparator_lambda();

		new SortedCollection().max_number();
	}

	public static void main1()
	{
		////////
		Comparator<Actor> comparator= Comparator.comparing(Actor::getMovies)
				.thenComparingInt(Actor::getAge)
								.thenComparing(Actor::getName,String.CASE_INSENSITIVE_ORDER).reversed();
		PracticeData.getActorList().stream().sorted(comparator).forEach(System.out::println);

		/// the max aged actor

		System.out.println("\n\nThe max aged actor:-");
		Actor actor = PracticeData.getActorList().stream().max(Comparator.comparing(Actor::getAge)).get();
		System.out.println(actor.getName());

		System.out.println("=========================");

		System.out.println("\n\nThe min aged actor:-");
		String name = PracticeData.getActorList().stream().min(Comparator.comparing(Actor::getAge)).get().getName();

		System.out.println(name);

		System.out.println("=========================");
		
		Map<Object, List<Integer>> rres = PracticeData.getActorList().stream().map(Actor::getMovies)
				.collect(Collectors.groupingBy(String::valueOf));

		System.out.println(rres);
	}

	public void actor_with_least_movies()
	{
		String res = PracticeData.getActorList().stream().min(Comparator.comparing(Actor::getMovies)).get().getName();

		System.out.println(res);
	}

	public void actor_name_list_with__movies_desc()
	{
		List<String> list = PracticeData.getActorList().stream()
				.sorted(Comparator.comparing(Actor::getMovies).reversed())
				.map(Actor::getName).collect(Collectors.toList());

		System.out.println(list);
	}

	public void actor_name_list_with_movies_desc_using_comparator_lambda()
	{
		Comparator<Actor> comparator= (a,b)->{
			
			if(a.getMovies()>b.getMovies())
			{
				return -1;
						
			} else if (a.getMovies() < b.getMovies())
			{
				return 1;
			} else
			{
				return 0;
			}
			
		};
		
		List<String> list = PracticeData.getActorList().stream()
				.sorted(comparator).map(Actor::getName)
				.collect(Collectors.toList());

		System.out.println(list);
	}

	public void max_number()
	{
		String[] givenList =
		{ "1", "23", "4", "45", "A", "arpan" };

		String x = Arrays.asList(givenList).stream().max(Comparator.comparing(String::valueOf)).get();

		Map res =
		Arrays.asList(givenList).stream()
						.collect(Collectors.groupingBy(Function.identity(),
						Collectors.maxBy(Comparator.comparing(String::valueOf))));
		System.out.println(x);

		System.out.println(res);
	}
}