package com.java.streams;

import java.util.Arrays;
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
		 * getWordLength(); getWord_occurences();
		 */
		getMaxMovie();

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

	private static void getMaxMovie()
	{
		List<Actor> data = PracticeData.getActorList();
		
		List<Actor> listOfActors = data.stream().filter(x ->

		x.getName().equals("Radhika") || x.getName().equals("Samantha"))
				.collect(Collectors.toList());
		
		// System.out.println(listOfActors);
		
		/*
		 * Actor name =
		 * listOfActors.stream().filter(data::contains).max(Comparator.comparing(Actor::
		 * getMovieIndustry)) .get(); // .get().getName();
		 */
		Actor name = listOfActors.stream().filter(data::contains)
				.max(Comparator.comparing(Actor::getMovies)).get();

		System.out.println(name);
	}
}
