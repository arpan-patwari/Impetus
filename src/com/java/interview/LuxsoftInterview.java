package com.java.interview;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.java.bo.Actor;
import com.java.bo.PracticeData;
import com.java.corejava.ImmutableClass;
import com.java.corejava.SuperActor;

public class LuxsoftInterview
{
	public static void main(String[] args)
	{
		List<String> deepCopy=PracticeData.getActorList().stream().map(Actor::getName).collect(Collectors.toList());

		ImmutableClass imm = new ImmutableClass(0, "arpan", deepCopy, new Date()
				);

		imm.getCompanies().add("test name");
		deepCopy.add("test string");
		imm.getDate().setYear(2034);

		System.out.println(imm.getCompanies());
		System.out.println(imm.getDate());

		new SuperActor();

	}
}
