package com.java.designpattern.abstractFactory;

public interface AbstractFactory<T>
{
	T create(String objectType);
}
