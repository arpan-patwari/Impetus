package com.java.interview;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java.bo.Actor;
import com.java.bo.PracticeData;

public class Solution
{
	public static void main(String[] args)
	{

		PracticeData.getActorList().stream().sorted(Comparator.comparing(Actor::getMovies)).collect(Collectors.toList())
				.forEach(System.out::println);

		/************/

		Map<Integer, Long> data = PracticeData.getActorList().stream().map(Actor::getMovies)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(data);
	}
}
