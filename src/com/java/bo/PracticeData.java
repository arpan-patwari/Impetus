package com.java.bo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface PracticeData
{
	static List<Actor> getActorList()
	{
		return Stream.of(
				new ActorBuilder().withAge(33).withMovies(10).withName("Radhika").withSsn().withGender("F")
						.withMovieIndustry("Lollywood").build(),

				new ActorBuilder().withAge(37).withMovies(13).withName("Samantha").withSsn().withGender("F")
						.withMovieIndustry("Lollywood").build(),

				new ActorBuilder().withAge(47).withMovies(15).withName("Pankaj").withGender("M")
						.withMovieIndustry("Bollywood").withSsn().build(),

				new ActorBuilder().withAge(43).withMovies(13).withName("Nawaz").withGender("M")
						.withMovieIndustry("Bollywood").withSsn().build(),

				new ActorBuilder().withAge(80).withMovies(50).withName("Amitabh").withGender("M")
						.withMovieIndustry("Bollywood").withSsn().build(),

				new ActorBuilder().withAge(37).withMovies(17).withName("Manoj").withGender("M")
						.withMovieIndustry("Tollywood").withSsn().build(),

				new ActorBuilder().withAge(57).withMovies(31).withName("Angshuman").withGender("M")
						.withMovieIndustry("Bollywood").withSsn().build(),

				new ActorBuilder().withAge(45).withMovies(13).withName("Aamir").withGender("M")
						.withMovieIndustry("Bollywood").withSsn().build(),

				new ActorBuilder().withAge(53).withMovies(15).withName("Kapil").withGender("M")
						.withMovieIndustry("Bollywood").withSsn().build(),

				new ActorBuilder().withAge(37).withMovies(2).withName("Diganta").withGender("M")
						.withMovieIndustry("Assamwood").withSsn(13).build(),

				new ActorBuilder().withAge(35).withMovies(2).withName("Parismita").withGender("F")
						.withMovieIndustry("Assamwood").withSsn(13).build()
				).collect(Collectors.toList());
	}

	static List<List<Integer>> getListOfIntegerList()
	{
		// Creating a list of Prime Numbers
		List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);

		// Creating a list of Odd Numbers
		List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

		// Creating a list of Even Numbers
		List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

		return Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
	}

	abstract void test();

	static String[] getWords()
	{
		return new String[]
		{ "This", "bangalore", "this", "city", "bangalore", "is", "more", "like", "bangalore" };
	}
}
