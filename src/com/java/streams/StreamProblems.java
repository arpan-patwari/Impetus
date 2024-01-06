package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java.bo.Actor;
import com.java.bo.PracticeData;

public class StreamProblems
{
	public static void main(String[] args)
	{
		WordFreqency();
	}
	
	public static void max_prime_numbers()
	{
		List<Integer> primeNumbers = Arrays.asList(5, 7, 11,13);
		
		Comparator<Integer> comparator= (a,b)-> {
			
			return a.compareTo(b);
		};
		
		Integer maxNum = primeNumbers.stream().max(comparator).get();
		System.out.println(maxNum);
	}
	
	public static void actor_movies_name()
	{
		Map<Integer, Long> map = PracticeData.getActorList().stream().map(Actor::getMovies)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map);
	}

	public static void test()
	{


		Integer actor = PracticeData.getActorList().stream().collect(Collectors.summingInt(Actor::getAge));


		PracticeData.getActorList().stream().collect(Collectors.toMap(x -> x.getName(), x -> x.getMovies())).entrySet()
				.forEach(x -> System.out.println(x.getKey()));
		;

		System.out.println(actor);
	}

	public static void SumEvenOfNumber()
	{
		List<Integer> list = new ArrayList<Integer>();

		list.add(2);
		list.add(6);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(8);
		list.add(9);

		System.out.println(list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x.intValue()).sum());
	}

	public static void WordFreqency()
	{
		List<String> wordsList = new ArrayList();
		wordsList.add("Debu");
		wordsList.add("Morning");
		wordsList.add("hi");
		wordsList.add("hi");
		wordsList.add("hello");

		System.out.println(
				wordsList.stream()
						.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> x.length())))
				);}
}
