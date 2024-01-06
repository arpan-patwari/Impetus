package com.java.leetcode;

public class ReverseInteger
{
	public static void main(String[] args)
	{
		System.out.println(reverse_mysol(1534236469));
		System.out.println(964632435 * 10 / 10);
	}

	public static int reverse(int n)
	{
		int res = 0;
		while (n != 0)
		{
			int ld = n % 10;
			int curRes = (res * 10) + ld;
			if ((curRes - ld) / 10 != res)
				return 0;
			res = curRes;
			n /= 10;
		}
		return res;

	}

	public static Integer reverse_mysol(Integer x)
	{
		
		if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
			return 0;

		Integer rem = 0;
		Integer sum = 0;
		while (x != 0)
		{
			rem = x % 10;
			x = x / 10;
			int prev = sum;
			sum = sum * 10;
			if ((sum / 10) != prev)
				return 0;
			sum = sum + rem;
		}
		return sum;
    }
}
