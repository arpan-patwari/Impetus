package com.java.corejava.threads;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModification
{

	public static void main(String[] args)
	{
		List<String> myList = new CopyOnWriteArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();

		while (it.hasNext())
		{
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3"))
			{
				// it.remove();
				myList.remove("6");

				myList.add("7");
			}
		}

		for (String value : myList)
		{
			System.out.println("List Value:" + value);
			if (value.equals("3"))
			{
				myList.remove("4");
				myList.add("6");
				myList.add("7");
			}
		}

		System.out.println("List Size:" + myList);

		Hashtable<String, String> myMap = new Hashtable<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext())
		{
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("1"))
			{
				myMap.remove("3");
				myMap.put("4", "4");
				myMap.put("5", "5");
			}
		}

		List<Integer> intList = new CopyOnWriteArrayList<>();
		intList.add(23);
		intList.add(1);
		intList.add(33);

		Iterator it222 = intList.iterator();

		while (it222.hasNext())
		{
			if (it222.next().equals(33))
			{
				intList.remove(Integer.valueOf(33));
				intList.add(44);
			}
		}

		System.out.println(intList);

	}

}
