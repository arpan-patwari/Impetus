package com.java.basics;

public class CallingClass implements SubInterface, SuperInterface
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new CallingClass().defautMethod();

		String test = "getNamesTest";
		String result = "";
		boolean containsUnderScore = test.contains("_");

		for (int i = 0; i < test.length(); i++)
		{
			if (test.charAt(i) > 64 && test.charAt(i) < 91 && !containsUnderScore)
			{
				char toAdd = (char) (test.charAt(i) + 32);
				result = result + '_' + toAdd;
			}
			else if (test.charAt(i) == '_')
			{
				i++;
				char toAdd = (char) (test.charAt(i) - 32);
				result = result + toAdd;
			}
			else
			{
				result = result + test.charAt(i);
			}

		}

		System.out.println(result);

	}

	public void test() throws Exception
	{
		SubInterface.staticMethod();
		SubInterface.super.defautMethod();
	}

	@Override
	public void defautMethod()
	{
		// TODO Auto-generated method stub
		SubInterface.super.defautMethod();
		SuperInterface.super.defautMethod();
	}

	@Override
	public void abstractMethod()
	{


	}
}
