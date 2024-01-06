package com.java.designpattern.abstractFactory;

public interface FactoryProvider
{

	static AbstractFactory<?> getFactory(String objectType)
	{
		if ("car factory".equals(objectType))
		{
			return new Carfactory();
		}
		if ("bike factory".equals(objectType))
		{
			return new Bikefactory();
		}
		return null;
	}


}
