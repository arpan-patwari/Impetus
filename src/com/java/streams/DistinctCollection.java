package com.java.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java.bo.Actor;
import com.java.bo.PracticeData;

public class DistinctCollection
{

	public static void main(String[] args)
	{

		List<Actor> distinctActors = PracticeData.getActorList().stream().distinct().collect(Collectors.toList());
		System.out.println("====Distinct actors======== \n" + distinctActors);
		
		List<Actor> distinctActorsByAge = PracticeData.getActorList().stream().filter(distinctByKey(Actor::getGender))
				.collect(Collectors.toList());
		System.out.println("====Distinct actors byb name======== \n" + distinctActorsByAge);
	}


	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor)
	{

		Map<Object, Boolean> seen = new HashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}


}
