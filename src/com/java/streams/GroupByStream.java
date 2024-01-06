package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.java.bo.Actor;
import com.java.bo.PracticeData;

public class GroupByStream
{
	public static void main(String[] args)
	{

		/*
		 * new GroupByStream().total_actors_by_industry(); new
		 * GroupByStream().total_movies_by_industry(); new
		 * GroupByStream().actor_name_list_based_on_gender(); new
		 * GroupByStream().industry_with_average_movies(); new
		 * GroupByStream().industry_with_summmaringInt(); new
		 * GroupByStream().actor_with_least_movies(); // new
		 * GroupByStream().actor_with_most_movies(); new
		 * GroupByStream().actor_with_most_movies1();
		 */

		System.out.println("\n\n\n");
		/*
		 * new GroupByStream().getWordLength(); new
		 * GroupByStream().getWordLength_List(); new
		 * GroupByStream().getWordLength_Set(); new
		 * GroupByStream().getwordLength_String();
		 */
		// new GroupByStream().getword_occurences();
		new GroupByStream().getwordLength_String();

		/*
		 * new GroupByStream().get_average_by_industry(); new
		 * GroupByStream().get_movies_list_by_industry();
		 */
	}

	public void actor_with_most_movies()
	{
		Map<String, Optional<Actor>> res = PracticeData.getActorList().stream().collect(
				Collectors.groupingBy(Actor::getGender, Collectors.maxBy(Comparator.comparing(Actor::getMovies))));

		System.out.println(res);
	}

	public void total_actors_by_industry()
	{
		Map<String, Long> res = PracticeData.getActorList().stream()
				.collect(Collectors.groupingBy(Actor::getMovieIndustry, Collectors.counting()));

		System.out.println(res);
	}

	public void total_movies_by_industry()
	{
		Map<String, Integer> res = PracticeData.getActorList().stream()
				.collect(Collectors.groupingBy(Actor::getMovieIndustry, Collectors.summingInt(Actor::getMovies)));

		System.out.println(res);
	}

	public void actor_name_list_based_on_gender()
	{
		Map<String, List<String>> res = PracticeData.getActorList().stream().collect(
				Collectors.groupingBy(Actor::getGender,
						Collectors.mapping(Actor::getName, Collectors.toList())));

		System.out.println(res);
	}

	public void industry_with_average_movies()
	{
		Map<String, Double> res = PracticeData.getActorList().stream()
				.collect(Collectors.groupingBy(Actor::getMovieIndustry, Collectors.averagingDouble(Actor::getMovies)));

		System.out.println(res);
	}

	public void industry_with_summmaringInt()
	{
		Map<String, IntSummaryStatistics> res = PracticeData.getActorList().stream()
				.collect(Collectors.groupingBy(Actor::getMovieIndustry, Collectors.summarizingInt(Actor::getMovies)));

		System.out.println(res);
	}

	public void industry_with_least_movies()
	{
		Map<String, Optional<Actor>> res = PracticeData.getActorList().stream().collect(
				Collectors.groupingBy(Actor::getMovieIndustry,
						Collectors.minBy(Comparator.comparingInt(Actor::getMovies))));
		System.out.println(res);
	}

	public void actor_with_most_movies1()
	{
		Map<String, Optional<Actor>> res = PracticeData.getActorList().stream()
				.collect(Collectors.groupingBy(Actor::getMovieIndustry,
						Collectors.maxBy(Comparator.comparing(Actor::getMovies)))

				);
		System.out.println(res);
	}

	/**
	 * getWordLength – group a given sentence by its word’s length
	 */
	public void getWordLength()
	{
		Map<Object, Integer> res = Arrays.stream(getWords())
				.collect(Collectors.groupingBy(String::valueOf, Collectors.summingInt(String::length)));
		System.out.println(res);
	}

	/**
	 * getWordLength_List – group a given words by its words’ length, return it as a
	 * List
	 * 
	 * @return
	 */
	public void getWordLength_List()
	{
		Map<Integer, List<String>> res = Arrays.stream(getWords())
				.collect(Collectors.groupingBy(x -> x.length(), Collectors.toList()));

		System.out.println(res);
	}

	/**
	 * getWordLength_Set – group a given sentence by its words’ length, return it as
	 * a Set
	 * 
	 * @return
	 */
	public void getWordLength_Set()
	{
		Map<Integer, Set<String>> res = Arrays.stream(getWords())
				.collect(Collectors.groupingBy(String::length, Collectors.toSet()));

		System.out.println(res);
	}

	public void getwordLength_String()
	{
		Map<Integer, String> res = Arrays.stream(getWords())
				.collect(Collectors.groupingBy(String::length, Collectors.joining(" || ")));

		System.out.println(res);
	}

	public void getword_occurences()
	{
		Map<String, Long> res = Arrays.stream(getWords())
				.collect(Collectors.groupingBy(x -> x.toUpperCase(), Collectors.counting()));

		System.out.println(res);
	}

	public void get_average_by_industry()
	{
		Map<String, Double> res = PracticeData.getActorList().stream().collect(

				Collectors.groupingBy(Actor::getMovieIndustry, Collectors.averagingDouble(Actor::getMovies))

		);

		System.out.println(res);
	}

	public void get_movies_list_by_industry()
	{
		Map<String, Set<Actor>> res = PracticeData.getActorList().stream().collect(
				Collectors.groupingBy(Actor::getMovieIndustry, Collectors.toSet())

		);

		System.out.println(res);
	}

	private String[] getWords()
	{
		return new String[]
		{ "This", "bangalore", "this", "city", "bangalore", "is", "more", "like", "bangalore" };
	}
}
