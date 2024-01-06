package com.java.streams.interview;

public class Ladder extends LudoElement
{
	Integer increment;

	public Ladder(Integer increment)
	{
		super();
		this.increment = increment;
	}

	public Integer getIncrement()
	{
		return increment;
	}

	public void setIncrement(Integer increment)
	{
		this.increment = increment;
	}
}
