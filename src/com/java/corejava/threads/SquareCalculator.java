package com.java.corejava.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator
{
	private static ExecutorService executor = Executors.newFixedThreadPool(10);

	public Future<Integer> calculate(Integer input)
	{
		return executor.submit(() -> {

			System.out.println("starting to sleep");

			if (input == 10)
			{
				Thread.sleep(1000);
			} else
			{
				Thread.sleep(100);
			}
			return input * input;
		});
	}


	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		Integer result = new SquareCalculator().calculate(1).get();
		System.out.println(result);

	
		executor.shutdown();
		
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {

			try
			{
				Thread.sleep(12000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 10000;
		
		});
		if (!future.isDone())
		{
			Thread.sleep(1000);
			future.complete(900);
		}

		System.out.println(future.get());
	}
}
