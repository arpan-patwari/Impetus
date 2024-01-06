package com.java.streams.interview;

public class Bucket
{
	Integer boxNo;

	LudoElement element;

	public Bucket(Integer boxNo, LudoElement element)
	{
		super();
		this.boxNo = boxNo;
		this.element = element;
	}

	public Integer getBoxNo()
	{
		return boxNo;
	}

	public void setBoxNo(Integer boxNo)
	{
		this.boxNo = boxNo;
	}

	public LudoElement getElement()
	{
		return element;
	}

	public void setElement(LudoElement element)
	{
		this.element = element;
	}

}
