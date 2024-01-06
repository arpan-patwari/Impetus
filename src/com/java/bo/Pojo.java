package com.java.bo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pojo
{
public static void main(String[] args)
{
	Human h1 = new Human(12, 25);
	Human h2 = new Human(13, 26);

	Human dup_h1 = new Human(12, 27);

	Set<Human> set = Stream.of(h1, h2).collect(Collectors.toSet());

	System.out.println(h1.hashCode() + "  " + h2.hashCode());
	System.out.println(h1.equals(h2));

	System.out.println(set);

	Map<Human, Integer> duplicateMap = new HashMap<Human, Integer>();
	duplicateMap.put(dup_h1, 1);
	duplicateMap.put(h1, 2);
	System.out.println("duplicateMap = " + duplicateMap);

	System.out.println(duplicateMap.get(h1));

	Set<Human> duplciateSet = Stream.of(dup_h1, h1).collect(Collectors.toSet());
	System.out.println(duplciateSet);

}

}


class Human
{
	int brainIQ;
	int noOfEyes;

	public int getBrainIQ()
	{
		return brainIQ;
	}

	public Human(int brainIQ, int noOfEyes)
	{
		super();
		this.brainIQ = brainIQ;
		this.noOfEyes = noOfEyes;
	}

	public void setBrainIQ(int brainIQ)
	{
		this.brainIQ = brainIQ;
	}

	public int getNoOfEyes()
	{
		return noOfEyes;
	}

	public void setNoOfEyes(int noOfEyes)
	{
		this.noOfEyes = noOfEyes;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(brainIQ);
	}

	@Override
	public boolean equals(Object obj)
	{
		return true;
		/*
		 * if (this == obj) return true; if (obj == null) return false; if (getClass()
		 * != obj.getClass()) return false; Human other = (Human) obj; return brainIQ ==
		 * other.brainIQ && noOfEyes == other.noOfEyes;
		 */
	}

	@Override
	public String toString()
	{
		return "Human [brainIQ=" + brainIQ + ", noOfEyes=" + noOfEyes + "]";
	}

}