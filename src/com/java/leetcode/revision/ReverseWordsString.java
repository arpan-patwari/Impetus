package com.java.leetcode.revision;

public class ReverseWordsString
{

	public static void main(String[] args)
	{
		System.out.println(new ReverseWordsString().reverseWords("a good   example"));
		System.out.println(new ReverseWordsString().reverseWords1("a good   example"));
	}

	public String reverseWords(String s)
	{
		s = s.trim();
		String[] words = s.split(" ");
		StringBuilder res = new StringBuilder();

		for (int i = words.length - 1; i > 0; i--)
		{
			res.append(words[i].trim());
			if(i!=0)
			{
				res.append(" ");
			}
		}

		return res.toString();
	}

	public String reverseWords1(String s)
	{
		s = s.trim();
		String[] words = s.split(" ");
		StringBuilder res = new StringBuilder();

		for (String word : words)
		{
			res.append(word.trim()).append(" ");
		}

		return res.toString();

	}


}
