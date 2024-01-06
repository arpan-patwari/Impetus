package com.java.leetcode.revision;

import java.util.Arrays;

public class LongestCommonPrefixRevision
{
	public String longestCommonPrefix(String[] strs)
	{
		Arrays.sort(strs);
		char[] test = strs[0].toCharArray();
		StringBuilder logestP = new StringBuilder();

		for (int i = 0; i < test.length; i++)
		{
			for (int j = 1; j < strs.length; j++)
			{
				if (test[i] != strs[j].charAt(i))
				{
					return logestP.toString();
				}
			}
		logestP.append(test[i]);
	}
	return logestP.toString();
}
}
