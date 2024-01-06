package com.java.corejava;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class ImmutableClass
{
	private final int id;
	private final String name;
	private final List<String> companies;
	private final Date date;

	public ImmutableClass(int id, String name, List<String> companies, Date date)
	{
		this.id = id;
		this.name = name;

		/*
		 * List<String> deepCopy = new ArrayList<>();
		 * 
		 * for (String s : companies) deepCopy.add(s);
		 * 
		 * // this.companies = deepCopy;
		 */
		this.companies = companies.stream().collect(Collectors.toList());

		Date tempDate = new Date();
		tempDate = (Date) date.clone();

		this.date = tempDate;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public Date getDate()
	{
		Date tempDate = new Date();
		tempDate = (Date) date.clone();
		return tempDate;
	}

	@Override
	public String toString()
	{
		return "ImmutableClass [id=" + id + ", name=" + name + ", companies=" + companies + ", date=" + date + "]";
	}

	public List<String> getCompanies()
	{
		return companies.stream().collect(Collectors.toList());

		/*
		 * List<String> deepCopy = new ArrayList<>(); for (String s : companies)
		 * deepCopy.add(s); return deepCopy;
		 */
	}
}
