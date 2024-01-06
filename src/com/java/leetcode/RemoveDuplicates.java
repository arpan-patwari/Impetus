package com.java.leetcode;

public class RemoveDuplicates
{
	public static void main(String[] args)
	{
		System.out.println(removeDuplicates("thisshit"));
	}

	static String removeDuplicates(String s)
	{
		int i=0,j=0;
		char[] input = s.toCharArray();
		char[] result = new char[s.length()];
		boolean visited[] = new boolean[256];

		while (i < s.length())
		{
			if (!visited[input[i]])
			{
				result[j] = input[i];
				j++;
			}
			visited[input[i]] = true;
			i++;
		}
		return new String(result).trim();
	}
}
