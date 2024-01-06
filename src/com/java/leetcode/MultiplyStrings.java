package com.java.leetcode;

/**
 * the code does not work fro larger numbers need a different approach
 * 
 * @author arpan-PC
 *
 */
public class MultiplyStrings
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(new MultiplyStrings().multiply("123453453454", "7333333"));
	}

	public String multiply(String num1, String num2)
	{
		int sum = convertToInteger(num1) * convertToInteger(num2);
		return String.valueOf(sum);
	}

	private int convertToInteger(String num)
	{
		num = new StringBuilder(num).reverse().toString();
		int number = 0;
		int i = 1;
		for (char c : num.toCharArray())
		{
			int n = c - 48;
			number = number + n * i;
			i = i * 10;
		}
		return number;
	}
}
