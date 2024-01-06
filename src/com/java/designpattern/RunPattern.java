package com.java.designpattern;

import com.java.designpattern.abstractFactory.AbstractFactory;
import com.java.designpattern.abstractFactory.Car;
import com.java.designpattern.abstractFactory.FactoryProvider;
import com.java.designpattern.adapter.Engine;
import com.java.designpattern.adapter.Vehicle;
import com.java.designpattern.adapter.VehicleEngine;
import com.java.designpattern.decorator.CheeseDecorator;
import com.java.designpattern.decorator.Pizza;
import com.java.designpattern.decorator.PizzaImpl;
import com.java.designpattern.decorator.SausageDecorator;
import com.java.designpattern.template.ErrorNote;
import com.java.designpattern.template.SuccesNote;

public class RunPattern
{

	public static void main(String[] args)
	{
		templatePattern();
	}

	public static void abstractFactoryDesignPattern()
	{
		AbstractFactory<Car> carFactory = (AbstractFactory<Car>) FactoryProvider.getFactory("car factory");
		Car car = carFactory.create("premium car");
		System.out.println(car.keyStartAndDrive());
		;
	}

	public static void decoratorPattern()
	{
		Pizza pizza = new SausageDecorator(new CheeseDecorator(new PizzaImpl()));
		System.out.println(pizza.decorate());
	}

	public static void adapterPattern()
	{

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleType("SUV");

		VehicleEngine vEngine = new VehicleEngine(vehicle);
		Engine engineSUV = vEngine.getEngine(vehicle);

		System.out.println(engineSUV.getEngineCapacity());
	}

	public static void templatePattern()
	{
		SuccesNote note = new SuccesNote();
		note.setUpNote();
		note.addSuccessTag();
		note.sendSignal();

		ErrorNote errNote = new ErrorNote();
		errNote.setUpNote();
		errNote.addErrorTag();
		errNote.sendSignal();

	}
}
