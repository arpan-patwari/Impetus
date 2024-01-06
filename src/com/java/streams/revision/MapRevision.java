package com.java.streams.revision;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java.bo.Actor;
import com.java.bo.ActorBuilder;
import com.java.bo.PracticeData;

public class MapRevision
{

	public static void main(String[] args)
	{
		// sortMap();
		//secMostOccurenced();
		String c = "Hello I was practising Java";
		c = c.substring(3, 5);
		byte[] b = c.getBytes();
		for (int i = 0; i < b.length; i++)
		{
			System.out.println(b[i]);
		}

	}

	public static void sortMap()
	{

		Map<Integer, String> actorWithAge = PracticeData.getActorList().stream()
				.collect(Collectors.toMap(x -> x.getMovies(), Function.identity(), (a, b) -> {

					if (a.getGender().equals("F"))
					{
						return a;
					} else
						return b;
				})).entrySet().stream().collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().getName()));


		Map<Integer, String> SORTEDmAP = actorWithAge.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

		System.out.println(SORTEDmAP);

	}

	static BinaryOperator<Actor> getBiFunction()
	{
		BinaryOperator<Actor> biFun = (a, b) -> {
			
			if(a.getGender().equals("F"))
			{
				return a;
			}
			else
				return b;
		};

		Actor act = biFun.apply(
				new ActorBuilder().withAge(33).withMovies(10).withName("Radhika").withSsn().withGender("F")
						.withMovieIndustry("Lollywood").build(),
				new ActorBuilder().withAge(33).withMovies(10).withName("arpan").withSsn().withGender("M")
						.withMovieIndustry("Lollywood").build());

		System.out.println(act);
		return biFun;
	}

	static BinaryOperator<Actor> getBasicBiFunction()
	{
		BinaryOperator<Actor> biFun = (a, b) -> a;

		return biFun;
	}

	private static String[] getWords()
	{
		return new String[]
		{ "This", "bangalore", "this", "city", "bangalore", "is", "more", "like", "bangalore" };
	}

	private static void secMostOccurenced()
	{
		Map<String, Long> occu = Arrays.asList(getWords()).stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		String city = occu.entrySet().stream().filter(x -> x.getValue().equals(10l)).findAny().get().getKey();

		System.out.println(city);
	}

	private static void secMostOccurence()
	{

		Entry<String, Long> secmostoccu =
				Arrays.asList(getWords()).stream().map(String::toUpperCase)
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
						.entrySet().stream().filter(e -> e.getValue() == 2l).findFirst().orElseThrow(()->new ArithmeticException());


		System.out.println(secmostoccu.getKey());
	}
}
