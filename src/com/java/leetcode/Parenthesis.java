package com.java.leetcode;

import java.util.Stack;

public class Parenthesis
{
	public static void main(String[] args)
	{
		// char[] input = { '{', '(', '{', '}', ')', '}', '[', ']', '{' };
		char[] input = {};
		System.out.println(isParenthesisValid("({[)"));
	}

	private static boolean isParenthesisValid(String s)
	{
		/*
		 * char[] input = { '{', '(', '{', '}', ')', '}', '[', ']', '{' };
		 */
		if (s.isEmpty())
			return false;

		Stack<Character> stack = new Stack<>();

		for (char in : s.toCharArray())
		{
			if (!stack.isEmpty())
			{
				char firstElement = stack.peek();

				boolean checkIfPushable = ((in == '}' && firstElement == '{') || (in == ')' && firstElement == '(')
						|| (in == ']' && firstElement == '['));

				if (checkIfPushable)
				{
					stack.pop();
				}
				else
				{
					stack.push(in);
				}
			}
			else
			{
				stack.push(in);
			}

		}

		return stack.isEmpty() ? true : false;

	}

}
