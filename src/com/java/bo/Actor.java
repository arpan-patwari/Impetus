
package com.java.bo;

import java.util.Objects;

import com.java.corejava.SuperActor;

public class Actor extends SuperActor implements Comparable<Actor>
{
	private Integer ssn;
	private String name;
	private Integer age;
	private Integer movies; 
	private String movieIndustry;
	private String gender;

	public String getMovieIndustry()
	{
		return movieIndustry;
	}

	public void setMovieIndustry(String movieIndustry)
	{
		this.movieIndustry = movieIndustry;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public Integer getSsn()
	{
		return ssn;
	}
	public void setSsn(Integer ssn)
	{
		this.ssn = ssn;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Integer getAge()
	{
		return age;
	}
	public void setAge(Integer age)
	{
		this.age = age;
	}
	public Integer getMovies()
	{
		return movies;
	}
	public void setMovies(Integer movies)
	{
		this.movies = movies;
	}
	@Override
	public int hashCode()
	{
		return Objects.hash(age, gender, movieIndustry, movies, name, ssn);
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(age, other.age) && Objects.equals(gender, other.gender)
				&& Objects.equals(movieIndustry, other.movieIndustry) && Objects.equals(movies, other.movies)
				&& Objects.equals(name, other.name) && Objects.equals(ssn, other.ssn);
	}
	@Override
	public String toString()
	{
		return "Actor [ssn=" + ssn + ", name=" + name + ", age=" + age + ", movies=" + movies + ", movieIndustry="
				+ movieIndustry + ", gender=" + gender + "]";
	}

	@Override
	public int compareTo(Actor o)
	{
		return o.movies.compareTo(o.movies);
	}
}