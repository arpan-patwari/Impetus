package com.java.streams.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakeAndLadder
{
	private static List<Bucket> buckets = new ArrayList<>();
	private static List<Person> currentState = new ArrayList();

	Bucket intialPosition = new Bucket(1, null);

	public static void main(String[] args)
	{
		setBuckets();

		Person p1 = new Person(1, buckets.get(0));
		Person p2 = new Person(1, buckets.get(0));

		p1 = throwDice(5, p1);

	}

	private static void setBuckets()
	{
		buckets =
				Arrays.asList(new Bucket(1, new Snake(10)),
						new Bucket(1, new Ladder(10)), new Bucket(1, null),
								new Bucket(1,new Snake(10))				
				);
	}

	private static Bucket getCurrentBucketForTheCast(Integer diceNo, Bucket currentBucket)
	{
		Integer boxNumber = currentBucket.getBoxNo() + diceNo;
		Integer bucketcalculatedNumber = 0;
		
		LudoElement element = buckets.get(boxNumber).getElement();
		if(element instanceof Snake)
		{
			bucketcalculatedNumber = boxNumber - ((Snake) element).getDrops();
		}
		if(element instanceof Ladder)
		{
			bucketcalculatedNumber = boxNumber + ((Ladder) element).getIncrement();
		}
		if(element==null)
		{
			bucketcalculatedNumber=boxNumber;
		}
		return buckets.get(bucketcalculatedNumber);
	}

	public static Person throwDice(Integer diceNo, Person person)
	{
		Bucket bucket = getCurrentBucketForTheCast(diceNo, person.getBucket());
		person.setBucket(bucket);
		return person;
	}
}
