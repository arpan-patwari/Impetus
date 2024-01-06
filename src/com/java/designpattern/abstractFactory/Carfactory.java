package com.java.designpattern.abstractFactory;

public class Carfactory implements AbstractFactory<Car>
{

	@Override
	public Car create(String objectType)
	{
		if ("premium car".equals(objectType))
		{
			return new PremiumCar();
		}
		if ("SUV car".equals(objectType))
		{
			return new SUVCar();
		}
		return null;
	}

}
