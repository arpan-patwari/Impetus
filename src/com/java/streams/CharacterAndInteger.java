package com.java.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterAndInteger
{
	public static void main(String[] args)
	{
		intToInteger();
	}

	private static void stringToCharacter()
	{
		String str = "capgeminibangalore";
		List<Character> listOfCharacter = str.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
		
		System.out.println(
		listOfCharacter.stream().filter(x -> Collections.frequency(listOfCharacter, x) > 1)
						.collect(Collectors.toSet()));
		
		
	}

	private static void occurenceOfCharacter()
	{
		String str = "capgeminibangalore";
		char c='a';
		
		int listOfCharacter = str.chars().mapToObj(x -> (char) x).filter(x -> Character.compare(x, c) == 0)
				.collect(Collectors.toList()).size();
		
		System.out.println(listOfCharacter);

	}

	private static void intToInteger()
	{
		int[] inp =
		{ 31, 23, 332, 133, 444 };

		System.out.println(
		Arrays.stream(inp)
				.mapToObj(i -> Integer.valueOf(i))
				.map(i -> String.valueOf(i)).filter(str -> str.startsWith("3"))
				.collect(Collectors.toList()));
	}
}
