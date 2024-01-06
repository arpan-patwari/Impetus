package com.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow
{
	public static void main(String[] args)
	{
		System.out.println(largestSubstringLengthRevision("abcabcbb"));

		System.out.println(largestSubstringLength("abcabcbb"));

		/*
		 * char c = ' '; int a = (int) c; System.out.println(a);
		 * 
		 * int rem = 2147483647;
		 * 
		 * int prevNum = num; num = num * 10 + rem;
		 * 
		 * 
		 * // System.out.println((rem - 3) / 10);
		 * 
		 * System.out.println((rem * 10) + 3);
		 */
	}

	/**
	 * 
	 * 
	 * @param s
	 */
	static int largestSubstringLength(String s)
	{
		char[] input = s.trim().toCharArray();// abcabcbb
		Set<Character> set = new HashSet<>();

		int start = 0, end = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < s.length(); i++)
		{
			if (set.add(input[end]))
			{
				maxSum = Math.max(maxSum, end - start + 1);
				end++;
			} else
			{
				set.remove(input[end]);
				start++;

			}
		}

		return maxSum;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	static int largestSubstringLengthRevision(String s)
	{
		int start = 0;
		int maxLength = 0;
		char[] charArr = s.toCharArray();
		Set<Character> uniq = new HashSet<Character>();

		int end = 1;
		while (end < s.length())
		{
			if (charArr[start] == charArr[end])
			{
				maxLength = uniq.size() > maxLength ? uniq.size() : maxLength;
				start++;
			} else
			{
				uniq.add(charArr[end]);
				end++;
			}
		}

		return maxLength;
	}
}