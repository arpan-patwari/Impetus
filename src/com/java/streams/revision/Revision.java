package com.java.streams.revision;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java.bo.Actor;
import com.java.bo.PracticeData;

public class Revision
{
	

	public static void main(String[] args)
	{

		/*
		 * actor_with_most_movies(); total_actors_by_industry();
		 * actor_name_list_based_on_gender(); total_movies_based_on_industry();
		 * most_movies_by_actor_based_on_industry();
		 */

		/*
		 * getWordLength(); getWord_occurences(); toListVCollectors();
		 */

		/*
		 * volvo_number_starts_with(); getDuplicateCharactersCapgemeni();
		 */

		volvo_number_starts_with();

	}

	static void toListVCollectors()
	{
		List<Character> actor = PracticeData.getActorList().get(0).getName().chars().mapToObj(x -> (char) x)
				.collect(Collectors.toList());

		actor.add(Character.valueOf('s'));

		System.out.println(actor);

	}


	static void actor_with_most_movies()
	{
		Actor actor =
		PracticeData.getActorList().stream().max(Comparator.comparing(Actor::getMovies)).get();

		System.out.println(actor);
	}

	static void total_actors_by_industry()
	{
		Map<String, Long> result =
		PracticeData.getActorList().stream()
				.collect(Collectors.groupingBy(Actor::getMovieIndustry, Collectors.counting()));
		
		System.out.println(result);
	}

	static void actor_name_list_based_on_gender()
	{
		Map<String, List<String>> result =
		PracticeData.getActorList().stream()
						.collect(Collectors.groupingBy(Actor::getGender, Collectors.mapping(Actor::getName,Collectors.toList())));

		System.out.println(result);
	}

	static void total_movies_based_on_industry()
	{
		Map<String, Integer> result =
		PracticeData.getActorList().stream()
						.collect(Collectors.groupingBy(Actor::getMovieIndustry,
								Collectors.summingInt(Actor::getMovies)));

		System.out.println(result);
	}

	static void most_movies_by_actor_based_on_industry()
	{
		Map<String, Optional<Actor>> result = PracticeData.getActorList().stream().collect(Collectors
				.groupingBy(Actor::getMovieIndustry, Collectors.maxBy(Comparator.comparing(Actor::getMovies))));

		/*
		 * Map<String, String> result1 = result.entrySet().stream().map(e ->
		 * Map.entry(e.getKey(), e.getValue().get().getName()))
		 * .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		 */

		Map<Entry<String, Optional<Actor>>, Object> result1 =
				
				result.entrySet().stream().collect(
						Collectors.toMap(Function.identity(), e -> e.getValue().get().getName(), (s1, s2) -> s2));
				
	}

	static void getWordLength()
	{
		Map<String, Long> result = Arrays.stream(getWords())
				.collect(Collectors.groupingBy(String::toUpperCase, Collectors.counting()));

		System.out.println(result);
	}

	static void getWord_occurences()
	{
		Map<Object, Integer> result = Arrays.stream(getWords())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(String::length)));

		System.out.println(result);
	}


	private static String[] getWords()
	{
		return new String[]
		{ "This", "bangalore", "this", "city", "bangalore", "is", "more", "like", "bangalore" };
	}

	static void volvo_number_starts_with()
	{
		int input[] =
		{ 32, 42, 33, 56, 23, 334, 3333 };

		Arrays.stream(input).boxed().map(String::valueOf).filter(x -> x.startsWith("3"))
				.collect(Collectors.toList()).forEach(System.out::println);

		Integer inputInteger[] =
		{ 32, 42, 33, 56, 23, 334, 3333 };
		
		System.out.println(Arrays.asList(inputInteger).stream().collect(Collectors.summingInt(x -> x)));

	}

	static void getDuplicateCharactersCapgemeni()
	{
		String str = "capgeminibangalore";
		List<Character> characters=str.chars().mapToObj(x->(char)x).collect(Collectors.toList());
		
		System.out.println(
				characters.stream().filter(x -> Collections.frequency(characters, x) > 1).collect(Collectors.toSet()));
		;

		System.out.println(
		str.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
						.entrySet().stream().filter(x -> x.getValue() > 1l).map(x -> x.getKey())
						.collect(Collectors.toList())
		);
	}
}
