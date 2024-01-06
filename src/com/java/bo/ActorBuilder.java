package com.java.bo;

import java.util.Random;

public class ActorBuilder
{
	private Integer ssn;
	private String name;
	private Integer age;
	private Integer movies; 
	private String movieIndustry;
	private String gender;
	
	public ActorBuilder withSsn(Integer... ssn)
	{
		this.ssn = (ssn.length == 0) ? new Random().nextInt() : ssn[0];
		return this;
	}
	

	public ActorBuilder withName(String name)
	{
		this.name=name;
		return this;
	}
	
	public ActorBuilder withAge(Integer age)
	{
		this.age=age;
		return this;
	}
	
	public ActorBuilder withMovies(Integer movies)
	{
		this.movies=movies;
		return this;
	}
	
	public ActorBuilder withMovieIndustry(String movieIndustry)
	{
		this.movieIndustry = movieIndustry;
		return this;
	}

	public ActorBuilder withGender(String gender)
	{
		this.gender = gender;
		return this;
	}

	public Actor build()
	{
		Actor act=new Actor();
		act.setAge(this.age);
		act.setSsn(this.ssn);
		act.setMovies(this.movies);
		act.setName(this.name);
		act.setGender(this.gender);
		act.setMovieIndustry(this.movieIndustry);
		
		return act;
	}
}
