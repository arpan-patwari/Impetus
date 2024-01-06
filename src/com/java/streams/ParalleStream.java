package com.java.streams;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ParalleStream
{
	public static void main(String[] args)
	{
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Cores " + cores);
		// List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
		List<Integer> EvenNumbers = new ArrayList<>();
		
		for (int i = 0; i < 21; i++)
		{
			EvenNumbers.add(new Random().nextInt());
		}

		System.out.println(EvenNumbers);
		LocalDateTime time = LocalDateTime.now();

		List<Integer> result = EvenNumbers.parallelStream().filter(x -> {
			System.out.println(Thread.currentThread().getName());
			return x > 3;
		}).collect(Collectors.toList());

		System.out.println(result);

		/**   */
		List<Integer> paralleResult = EvenNumbers.parallelStream().map(x -> x + 3).collect(Collectors.toList());

		System.out.println(Duration.between(time, LocalDateTime.now()).getNano());
		System.out.println(paralleResult);

		for (int i = 0; i < 21; i++)
		{
			EvenNumbers.add(new Random().nextInt());
		}

		System.out.println(EvenNumbers);

		LocalDateTime segtime = LocalDateTime.now();

		List<Integer> seqResult = EvenNumbers.stream().map(x -> x + 3).collect(Collectors.toList());
		System.out.println(Duration.between(segtime, LocalDateTime.now()).getNano());
		System.out.println(seqResult);
	}
}
