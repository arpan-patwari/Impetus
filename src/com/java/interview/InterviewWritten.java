package com.java.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewWritten
{
	public static void main(String[] args)
	{
		int[] test =
		{ 3, 5, 3, 9, 3,3, 5, 2, 1, 2 };
		List<Integer> input = Arrays.stream(test).boxed().collect(Collectors.toList());

		System.out.println(input.stream().filter(item -> (Collections.frequency(input, item) > 1)).distinct().sorted()
				.collect(Collectors.toList()));

		boolean[] places = new boolean[256];
		int[] result = new int[test.length];
		int resPoj = 0;

		for (int i = 0; i < test.length; i++)
		{
			if (places[test[i]])
			{
				result[resPoj++] = test[i];
				places[test[i]] = false;
			}
			else
			{
				places[test[i]] = true;
			}
		}

		int[] toreturn = Arrays.copyOfRange(result, 0, resPoj);
		Arrays.sort(toreturn);

		for (int i : toreturn)
		{
			System.out.print(i + ",");
		}
	}

}
