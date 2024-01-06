package com.java.streams.interview;

public class Snake extends LudoElement
{
	Integer drops;

	public Snake(Integer drops)
	{
		super();
		this.drops = drops;
	}

	public Integer getDrops()
	{
		return drops;
	}

	public void setDrops(Integer drops)
	{
		this.drops = drops;
	}
}
