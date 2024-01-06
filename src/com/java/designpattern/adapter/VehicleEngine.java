package com.java.designpattern.adapter;

public class VehicleEngine
{

	private Vehicle vehicle;

	public VehicleEngine(Vehicle vehicle)
	{
		super();
		this.vehicle = vehicle;
	}

	public Engine getEngine(Vehicle vehicle)
	{
		Engine engine=new Engine();
		if("bike".equals(vehicle.getVehicleType()))
		{
			engine.setEngineCapacity("0.4l");
			engine.setEngineType("four stroke");

			return engine;
		}
		if ("SUV".equals(vehicle.getVehicleType()))
		{
			engine.setEngineCapacity("1.5");
			engine.setEngineType("six stroke");

			return engine;
		}

		engine.setEngineCapacity(".1");
		engine.setEngineType("zero stroke");

		return engine;
	}
}
