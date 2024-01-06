package com.java.corejava.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItemGateway
{
	public List<Integer> getItems(List<Integer> items)
	{

		// Create a CompletableFuture for each item being requested
		// and start each request asynchronously
		List<CompletableFuture<List<Integer>>> futures = items.stream()
				.map(item -> CompletableFuture.supplyAsync(() -> getItem(item))).collect(Collectors.toList());

		// Wait for ALL CompletableFutures to finish then return
		return futures.stream().map(CompletableFuture::join).flatMap(List::stream).collect(Collectors.toList());
	}

	private List<Integer> getItem(Integer item)
	{
		try
		{
			// Simulate a call to some external resource
			// by sleeping for a second
			System.out.println("Start: " + item);
			Thread.sleep(1000);
			System.out.println("End: " + item);
			return new ArrayList<>(item);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static void main(String[] args)
	{
		List<Integer> items = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());

		ItemGateway itemGateway = new ItemGateway();

		long startTime = System.currentTimeMillis();

		List<Integer> results = itemGateway.getItems(items);

		System.out.println(String.format("Done in %s ms", (System.currentTimeMillis() - startTime)));

		System.out.println("Results: " + results.stream().map(Object::toString).collect(Collectors.joining(",")));

		System.exit(0);
	}

}
