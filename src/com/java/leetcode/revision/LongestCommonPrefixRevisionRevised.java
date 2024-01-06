package com.java.leetcode.revision;

import java.util.Arrays;

public class LongestCommonPrefixRevisionRevised
{

	public static void main(String[] args)
	{
		String[] strs =
		{ "1war", "1arnab", "1ardip" };

		// System.out.println(new
		// LongestCommonPrefixRevisionRevised().longestCommonPrefix(strs));
		System.out.println(new LongestCommonPrefixRevision().longestCommonPrefix(strs));
	}

	public String longestCommonPrefix(String[] strs)
	{

		Arrays.sort(strs);
		String first = strs[0];
		StringBuilder prefix = new StringBuilder();

		for (int i = 0; i < first.length(); i++)
		{
			char c = first.charAt(i); 
			for (int j = 1; j < strs.length; j++)
			{

				if (c != strs[j].charAt(i))
				{
					return prefix.toString();
				}
				if (j == strs.length - 1)
				{
					prefix.append(c);
				}
			}
		}
		return prefix.toString();
	}
}
