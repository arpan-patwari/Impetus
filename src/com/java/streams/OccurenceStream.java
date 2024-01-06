package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurenceStream
{
	
	public static void secondMostOccuringNumber()
	{
		Integer[] input =
		{ 2, 3, 4, 5, 2, 2, 2, 3, 3, 3, 3 };

		Comparator<Entry<Integer, Long>> comp = (a, b) -> {
			if (a.getValue() < b.getValue())
				return 1;
			if (a.getValue() > b.getValue())
				return -1;
			else
				return 0;
		};

		List<Integer> test =

		Arrays.asList(input).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
						.entrySet().stream().sorted(comp)
						.map(x -> x.getKey()).collect(Collectors.toList());
				
		System.out.println(test.get(2));

	}

	
	public static void secondMostOccuringCharacter()
	{
		String input = "aaaasssdddddcccvv";

		List<Character> test = input.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
	}
}
