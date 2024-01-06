package com.java.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java.bo.Actor;
import com.java.bo.PracticeData;

public class Maps
{
	// actor with thier no. of movies
	private Map<Integer, Actor> data = PracticeData.getActorList().stream()
			.collect(Collectors.toMap(Actor::getMovies, Function.identity(), (s1, s2) -> s2));


	private Map<String, Long> industryWithActors = PracticeData.getActorList().stream()
			.collect(Collectors.groupingBy(Actor::getMovieIndustry, Collectors.counting()));


	public static void main(String[] args)
	{
		new Maps().sortMap();
		new Maps().largestValue();
	}

	public void sortMap()
	{
		System.out.println(data.keySet());
		Map<Integer, Actor> sortedMap = data.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (s1, s2) -> s2, LinkedHashMap::new));

		System.out.println(sortedMap.keySet());
	}

	public void largestValue()
	{
		System.out.println(industryWithActors);
		String biggestIndustry = industryWithActors.entrySet().stream().max(Map.Entry.comparingByValue()).get()
				.getKey();

		System.out.println(biggestIndustry);
	}

	public void get_movies_list_by_industry()
	{


		System.out.println();
	}


	public void secondMostOccuringString()
	{

		String[] test =
		{ "aaa", "bbb", "ccc", "bbb", "aaa", "aaa", "ddd" };
		List<String> list = Arrays.asList(test);

		Map<String, Long> result = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Object[] sortedMapVals = result.values().toArray();

		Arrays.sort(sortedMapVals, Collections.reverseOrder());

		Long secondLargestVAl = (Long) sortedMapVals[1];

		Entry<String, Long> value = result.entrySet().stream().filter(x -> x.getValue().equals(secondLargestVAl))
				.findFirst().get();

		System.out.println(value.getKey());

		/*
		 * Map<String, Long> result = new HashMap<String, Long>(); for(String s:list) {
		 * if(result.containsKey(s)) { long count= result.get(s); result.put(s,
		 * count++); } else { result.put(s, 1l); } }
		 * 
		 * long max = 0; long sMax = -1;
		 * 
		 * String maxS = null; String maxSec = null;
		 * 
		 * 
		 * for(String s:result.keySet()) { if (result.get(s) > sMax) { if (result.get(s)
		 * > max) { sMax = max; maxS = s; } else { maxSec = s; }
		 * 
		 * max=result.get(s).longValue();
		 * 
		 * } }
		 * 
		 * System.out.println(maxS);
		 */

	}

}
