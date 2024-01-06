package com.java.leetcode;

public class LongestCommonPrefix
{
	public static void main(String[] args)
	{
		String[] strs =
		{ "aaa", "aa", "aaa" };

		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));

		;
	}

	@SuppressWarnings("null")
	public static void main1(String[] args)
	{
		System.out.println("flow".indexOf("flower"));
		;
		String[] strs = { "flower", "flow", "flight" };
		int minLength=Integer.MAX_VALUE;
		char[][] arrays = null;
		char[] res = null;

		for (int i = 0; i < strs.length; i++)
		{
			arrays[i] = strs[i].toCharArray();
			if(minLength>strs[i].length())
			{
				minLength=strs[i].length();
			}
		}

		char[] firstString = arrays[0];

		int j = 0;

		while (j < firstString.length)
		{
			// char[] compare = firstString[j];
			int arrayLength = arrays[j].length;
			boolean allMatch = false;
			for (int i = 1; i < arrayLength; i++)
			{
				if (firstString[j] == arrays[i][j])
				{
					allMatch = true;
				} else
				{
					allMatch = false;
					break;
				}
				if (allMatch && i == arrayLength - 1)
				{
					res[j] = firstString[j];
				}
			}
			if (!allMatch)
				break;
			j++;

		}
	}

	public String longestCommonPrefix(String[] strs)
	{
		int totalStrings = strs.length;
		char[] arr = strs[0].toCharArray();
		StringBuilder prefix = new StringBuilder();

		if (totalStrings == 1)
		{
			return strs[0];
		}

		for (int i = 0; i < arr.length; i++)
		{
//			boolean doesThisCharMatch = false;
			for (int j = 1; j < totalStrings; j++)
			{
				if (strs[j].length() <= i)
				{
					return prefix.toString();
				}
				if (strs[j].charAt(i) != arr[i])
				{
					return prefix.toString();
				}
				if (j == totalStrings - 1)
				{
					prefix.append(arr[i]);
				}
			}
		}
		return prefix.toString();
	}
}
