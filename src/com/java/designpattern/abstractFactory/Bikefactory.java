package com.java.designpattern.abstractFactory;

public class Bikefactory implements AbstractFactory<Bike>
{

	@Override
	public Bike create(String objectType)
	{
		if ("MopedBike".equals(objectType))
		{
			return new MobedBike();
		}
		if ("HeavyBike".equals(objectType))
		{
			return new HeavyBike();
		}
		if ("MopedBike".equals(objectType))
		{
			return new MobedBike();
		}
		return null;
	}

}
