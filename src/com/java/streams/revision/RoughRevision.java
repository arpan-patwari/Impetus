package com.java.streams.revision;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java.bo.Actor;
import com.java.bo.PracticeData;

public class RoughRevision
{

	public static void main(String[] args)
	{

		characterFreqeuncy_alphabetical();
		// testname();

		/*
		 * List<Actor> reverseNameList = PracticeData.getActorList().stream()
		 * .sorted(Comparator.comparing(Actor::getName).reversed()).collect(Collectors.
		 * toList());
		 * 
		 * System.out.println(reverseNameList);
		 * 
		 * // ==================================//
		 * 
		 * Actor firstActor = PracticeData.getActorList().stream().findFirst().get();
		 * 
		 * System.out.println(firstActor);
		 * 
		 * Actor anyActor = PracticeData.getActorList().stream().findAny().get();
		 * 
		 * System.out.println(anyActor);
		 */

		//expllicitComparator();
		//sortBySQLStyle();
		// actor_with_most_movies();
		// total_actors_by_industry();
		// industry_with_least_movies_and_name();
		// getwordLength_String();
		// SecndMostOccurring();

	}

	private static void expllicitComparator()
	{
		Comparator<Actor> com = (a, b) -> {

			if (a.getAge() > b.getAge())
				return -1;
			else if (a.getAge() < b.getAge())
				return 1;
			else
				return 0;
		};

		System.out.println(PracticeData.getActorList().stream()
				.sorted(com)
				.map(Actor::getAge)
				.collect(Collectors.toList()));
	}

	private static void sortBySQLStyle()
	{
		System.out.println(
				PracticeData.getActorList().stream()
						.sorted(Comparator.comparing(Actor::getMovies)
								.thenComparing(Comparator.comparing(Actor::getAge)))
						.collect(Collectors.toMap(Actor::getName, Actor::getMovies)));
	}

	private static void actor_with_most_movies()
	{
		System.out.println(PracticeData.getActorList().stream().max(Comparator.comparing(Actor::getMovies))
		);
	}

	private static void total_actors_by_industry()
	{

		System.out.println(PracticeData.getActorList().stream()
				.collect(Collectors.groupingBy(Actor::getMovieIndustry, Collectors.counting())));
	}

	private static void industry_with_least_movies_and_name()
	{
		System.out.println(
				PracticeData.getActorList().stream()
						.collect(Collectors.groupingBy(Actor::getMovieIndustry,
								Collectors.minBy(Comparator.comparing(Actor::getMovies))))
						.entrySet().stream().collect(Collectors.toMap(
								Map.Entry::getKey, s -> s.getValue().get().getName()))
		);
	}

	private static void getwordLength_String()
	{
		System.out.println(Arrays.stream(PracticeData.getWords())
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new,
						Collectors.summingInt(String::length))));
	}

	private static void SecndMostOccurring()
	{
		System.out.println(Arrays.stream(PracticeData.getWords())
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 2l).findFirst()
				.orElseThrow(() -> new RuntimeException()));
			
	}

	public static void testname()
	{
		
		System.out.println(
				PracticeData.getActorList().stream()
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				);

		System.out.println(
				PracticeData
						.getActorList().stream()
						.sorted(Comparator.comparing(Actor::getName).reversed()
								.thenComparing(Comparator.comparing(Actor::getAge)))
						.collect(Collectors.toMap(Actor::getName, Actor::getAge)));
	}

	public static void characterFreqeuncy_alphabetical()
	{
		String input = "HelloWorld";

		System.out.println(input.chars().mapToObj(x -> (char) x).collect(Collectors.toList()).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (oldValue, newValue) -> oldValue,
						LinkedHashMap::new)));

		List<Character> list = input.chars().mapToObj(x -> (char) x).collect(Collectors.toList());

		System.out.println(
				list.stream().filter(x -> Collections.frequency(list, x) > 1).distinct().collect(Collectors.toList()));
	}
}
