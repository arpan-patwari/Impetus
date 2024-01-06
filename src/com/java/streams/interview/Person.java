package com.java.streams.interview;

public class Person
{

	Integer personId;
	Bucket bucket;

	public Person(Integer personId, Bucket bucket)
	{
		super();
		this.personId = personId;
		this.bucket = bucket;
	}

	public Integer getPersonId()
	{
		return personId;
	}

	public void setPersonId(Integer personId)
	{
		this.personId = personId;
	}

	public Bucket getBucket()
	{
		return bucket;
	}

	public void setBucket(Bucket bucket)
	{
		this.bucket = bucket;
	}

}
