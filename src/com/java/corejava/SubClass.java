package com.java.corejava;

import com.java.bo.Actor;

public class SubClass extends SuperClass
{
	@Override
	public Actor getActor()
	{
		return new Actor();
	}
}
