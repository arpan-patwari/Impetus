package com.java.leetcode;

public class MyAToi
{
	public static void main(String[] args)
	{
		System.out.println(new MyAToi().myAtoi("-91283472332"));
	}

	public int myAtoi(String s)
	{
		char[] inp = s.trim().toCharArray();
		int num = 0;
		char first = '+';
		int start = 0;

		if (inp.length == 0)
			return 0;

		if (inp[0] == '-' || inp[0] == '+')
		{
			first = inp[0];
			if (inp.length > 1)
			{
				start = 1;
			} else
			{
				return 0;
			}
		}

		for (int i = start; i < inp.length; i++)
		{
			if(inp[i]>47 && inp[i]<58)
			{
				int rem = inp[i] - 48;
				if (num > (Integer.MAX_VALUE - rem) / 10)
				{
					return first == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
				num = num * 10 + rem;
			}
			else
			{
				return num == 0 ? 0 : getNum(first, num);
			}
		}
		return getNum(first, num);
	}

	private int getNum(char first, int num)
	{
		return first == '-' ? 0 - num : num;
	}
}
