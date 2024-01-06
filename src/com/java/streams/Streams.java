package com.java.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.bo.PracticeData;

/**
 * @author arpan-PC
 */
public class Streams
{

	public static void main(String[] args) throws IOException
	{
		// testCode();
		// getMAxMinNumber();
		// getCount();

		/*
		 * List<Integer> arrList = Arrays.asList(1,2,3,45,4,6);
		 * 
		 * arrList.stream().filter(x->{ System.out.println("inside file=ter"); return
		 * true; }) .collect(Collectors.toList()).forEach(x->System.out.print(x));
		 * 
		 * 
		 * Map<Integer,Integer> map= NormalMap(arrList);
		 * 
		 * System.out.println(map);
		 */

		/**
		 * flat map operation
		 */

		/*
		 * PracticeData.getActorList().stream().map(e ->
		 * 
		 * { System.out.println("test"); System.out.println(e + "this gender"); return
		 * e; }).collect(Collectors.toList());
		 */

		Map<StringBuilder, Integer> testMap = new HashMap<StringBuilder, Integer>();

		StringBuilder sb = new StringBuilder("arpan");
		testMap.put(sb, 5);

		System.out.println(testMap.get(sb));

		sb.append("patwari");


		System.out.println(testMap.get(sb));

		StringBuilder sb1 = new StringBuilder("arpan");
		System.out.println(testMap.get(sb1));
		/*
		 * Map<Double, Integer> integerMap = new HashMap<Double, Integer>();
		 * integerMap.put(0.45, 12);
		 * 
		 * Double d = 0.45; Double e = 0.45; Float f = 0.45f;
		 * 
		 * System.out.println(d.equals(f));
		 */
		/*
		 * String str = "arpan"; Map<String, Integer> testStringMap = new
		 * HashMap<String, Integer>(); testStringMap.put(str, 1); str = "patwari";
		 * 
		 * System.out.println(testStringMap.get(str));
		 */

	}

	/**
	 * to a normal map
	 * 
	 * @return
	 */
	public static Map<Integer,Integer>  NormalMap(List<Integer> arrList)
	{
		return arrList.stream()
				.collect(Collectors.toMap(Function.identity(),x->x/3));
	}

	/**
	 * 
	 * @param arrList
	 * @return
	 */
	public List<Integer> flatMapOperation(List<Integer> arrList1, List<Integer> arrList2)
	{
		List<List<Integer>>  listOfList= Arrays.asList(arrList1,arrList2);

		String[][] words = {
				{"This", "is", "a", "test", "file"},
				{"This", "test", "file", "is"},
				{"a", "demo", "of", "flatMap"}
		};
		return null;
	}

	public static void testCode() throws IOException
	{
		Path path = Paths.get("C:/java-workspace/cities.txt");
		List<String> lines = Files.readAllLines(path);

		/*
		 * Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
		 * Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
		 */

		/*
		 * Stream<String> words =
		 * lines.stream().flatMap(line->Stream.of(line.split(" "))); Map<String, Long>
		 * mapped =
		 * words.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()
		 * ));
		 */

		Map<String, Long> mapped = lines.stream().flatMap(line -> Stream.of(line.split("\\s+")))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

		System.out.println(mapped);
	}

	public static void seeStream(List<Integer> arrList)
	{
		Stream<Integer> t= arrList.stream();
		Predicate<Integer> t1= x->x==2;

		Function<Integer,Integer> r = x->x/2;
	}

	public static void studyFlatmap()
	{   
		// Creating a list of Prime Numbers
		List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);

		// Creating a list of Odd Numbers
		List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

		// Creating a list of Even Numbers
		List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> listOfListofInts =
				Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);



		System.out.println("The Structure before flattening is : " +
				listOfListofInts);

		// Using flatMap for transformating and flattening.
		List<Integer> listofInts  = 
				//Stream<List<Integer>>
				listOfListofInts.stream()

				//Stream<Integer>
				.flatMap(list -> list.stream())

				//
				.collect(Collectors.toList());

		Stream<List<Integer>> list111 = listOfListofInts.stream();

		Stream<Integer> listStream = list111.flatMap(x -> x.stream());

		List<Integer> resList = listStream.collect(Collectors.toList());

		/*
		 * Stream<List<Integer>> testStream1=listOfListofInts.stream();
		 * 
		 * Stream<Integer> streamInt = testStream1.flatMap(x->x.stream());
		 * 
		 * Stream<Stream<Integer>> streamInts = testStream1.map(x->x.stream());
		 */



		System.out.println("The Structure after flattening is : " +
				listofInts);
	}

	public static void getMAxMinNumber()
	{
		Integer min = Stream.of(1, 2, 3, 4, 5, 6, 7).max(Comparator.comparing(x -> x)).get();
		Integer max = Stream.of(1, 2, 3, 4, 5, 6, 7).min(Comparator.comparing(Integer::valueOf)).get();

		System.out.println(min + "  " + max);

	}

	public static void getCount()
	{
		long count = PracticeData.getActorList().stream().filter(x -> x.getName().length() > 6).count();
		System.out.println(count);
	}

	private static void getWordsFromText() throws IOException
	{
		Path path = Paths.get("C:/java-workspace/cities.txt");
		List<String> lines = Files.readAllLines(path);
		
		Stream<String> lines1 = lines.stream().flatMap(line -> Stream.of(line.split("\n")));
		
	}
}