package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.bo.PracticeData;

public class FlatMap
{
	public static void main(String[] args)
	{
		List<Long> lstOfLong = Arrays.asList(1l, 4l, 16l, 7l, 5l);
		List<Integer> lstOfInteger = Arrays.asList(1, 4, 16, 7, 5);

		getHalvedValues(lstOfLong).forEach(System.out::print);
		getHalvedValues(lstOfInteger).forEach(System.out::print);
	}

	public static void main11(String[] args)
	{
		List<List<Integer>> listListInteger = PracticeData.getListOfIntegerList();

		Stream<List<Integer>> streamOfLists = listListInteger.stream();
		Stream<Integer> streamOfInteger = streamOfLists.flatMap(x->x.stream());
		streamOfInteger.collect(Collectors.toList()).forEach(System.out::println);
	}

	public static <T> Stream<T> flattenner_arrays(T[] arrays_one,T[] arrays_two)
	{
		Stream<T> result = Stream.of(arrays_one,arrays_two).flatMap(Arrays::stream);
		return result;
	}

	public static <T> Stream<T> flattener_list(List<T> arr_one, List<T> arr_two)
	{
		Stream<T> result = Stream.of(arr_one,arr_two).flatMap(x->x.stream());
		return result;
	}

	public static List<? extends Number> getHalvedValues(List<? extends Number> input)
	{
		Function<Number,Number> calculator = x->{
			Number result=0;
			if(x instanceof Integer)
			{
				result=  x.intValue()/2;
			}
			else if (x instanceof Double)
			{
				result=  x.doubleValue()/2;
			}
			else if (x.getClass().equals(Long.class))
			{
				result = x.longValue() / 2;
			}
			else
			{
				throw new NumberFormatException("The number type is different not compatible");
			}
			return result;
		};
		return input.stream().map(calculator).collect(Collectors.toList());
	}
}
