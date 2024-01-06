package com.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SumZeroTriplets
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		/*
		 * List<Integer> list =
		 * PracticeData.getActorList().stream().map(Actor::getAge).collect(Collectors.
		 * toList());
		 * 
		 * List<Integer> list2 =
		 * PracticeData.getActorList().stream().map(Actor::getAge).collect(Collectors.
		 * toList());
		 * 
		 * HashSet<List<Integer>> set = new HashSet<>(); set.add(list); set.add(list2);
		 * 
		 * System.out.println(set);
		 */
		System.out.println(new SumZeroTriplets().threeSum(new int[]
		{ -1, 0, 1, 2, -1, -4 }));
		// -1,-1,0,2,3,4
		;
	}

	public List<List<Integer>> threeSum(int[] nums)
	{
		Arrays.sort(nums);

		Set<List<Integer>> set = new HashSet<>();

		for (int i = 0; i < nums.length - 3; i++)
		{
			int k = i + 1;
			int j = nums.length - 3;
			int sum = 0;

			List<Integer> list = new ArrayList<>();
			while (k != j)
			{
				sum = nums[i] + nums[j] + nums[k];
				if (sum == 0)
				{
					list.add(nums[j]);
					list.add(nums[k]);
					set.add(list);
					k++;

				}
				if (sum < 0)
				{
					k++;
				}
				if (sum > 0)
				{
					j--;
					;
				}
			}
		}
		return null;
	}

	public List<List<Integer>> threeSumForContinuosArray(int[] nums)
	{

		HashSet<List<Integer>> set = new HashSet<>();

		for (int i = 0; i < nums.length - 3; i++)
		{
			int k=i+1;
			int counter=0;
			int sum=nums[i];
			
			List<Integer> list= new ArrayList<>();
			list.add(nums[i]);

			while(k<nums.length && counter<2)
			{
				sum=sum+nums[k];
				counter++;
				list.add(nums[k]);

				if (sum == 0 && counter == 2)
				{
					set.add(list);
				}
				k++;
			}
		}
		return set.stream().collect(Collectors.toList());
	}
}
