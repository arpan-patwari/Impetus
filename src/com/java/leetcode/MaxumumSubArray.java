package com.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxumumSubArray
{
	public static void main(String[] args)
	{
		int[] array= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(array));
	}

	/**
	 * The max sub array
	 * 
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums)
	{
		int sum = 0;
		int max = Integer.MIN_VALUE;

		int start = 0, end = 0;

		List<Integer> maxArray = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++)
		{
			sum = sum + nums[i];
			if (sum > max)
			{
				max = sum;
				maxArray.add(nums[i]);
			}

			if (sum < 0)
			{
				sum = 0;
			}
		}
		return max;
	}

	public int[] old_thought(int[] nums)
	{

		Integer max = 0;
		Integer sum = nums[0];

		int i = 0, start = 0, end = 0;

		while (i < nums.length)
		{
			sum = sum + nums[i];
			if (sum > max)
			{
				max = sum;
				end = i;
			}

			i++;
			if (sum < 0)
			{
				sum = 0;
				start = i;
			}
		}
		return Arrays.copyOfRange(nums, start, end + 1);

	}


	public static int maxSubArrayBruteForce(int[] nums)
	{
		int len = nums.length;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < len; i++)
		{
			int sum = 0;
			int j = i;
			while (j < len)
			{
				sum = nums[j] + sum;
				if (maxSum < sum)
				{
					maxSum = sum;
				}
				j++;
			}
			if (nums[i] > maxSum)
			{
				maxSum = nums[i];
			}
		}

		return maxSum;

	}

}
