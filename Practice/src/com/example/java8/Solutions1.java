package com.example.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Solutions1 {

	public static void main(String[] args) throws IOException {

		// 1.sort array by length
		String[] array = { "aaaa", "ccc", "dd", "eeee","bbbbs" };
		List<String> list = Arrays.asList(new String[] { "aaaa", "cccc", "dddd", "eeee","bbbbs" });
		sort(array);

		// 2.sort and compare ignore case
		sort2(array);
		
		//3.count strings greater than
		countLenGreaterThanThree(list);
		
		//4.read from files as stream of strings
		readFromFile();
		
		//5.map 
		convertToLowerCase(list);
		
		//using peek // get powers from 1 to 100
		getPowers();
		
		//get distict strings
		getDistinctStrings(array);
		
		System.out.println("\n\n\n\n");
		//sorting using comparitor and string by length
		sort3(array);
		
	}

	private static void sort3(String[] array) {
		
		Stream<String> longestFirst = Stream.of(array).sorted(Comparator.comparing(String::length).reversed());
		longestFirst.forEach(i -> System.out.println(" "+i));
		
	}

	private static void getDistinctStrings(String[] array) {
		
		Stream<String> distinct = Stream.of(array).distinct();
		distinct.forEach(i -> System.out.println(" "+i));
	}

	private static void getPowers() {
		
		Object[] powers = Stream.iterate(1.0, i -> i * 2)
				.peek(e -> System.out.println("fetching "+e)) //to debug otherwise works
				.limit(20)
				.toArray();
		
	}

	private static void convertToLowerCase(List<String> list) {

		//with method expreession
		Stream<String> array = list.stream().map(String::toLowerCase);
		
	}

	private static void readFromFile() throws IOException {
		Path path = Paths.get(System.getProperty("user.dir")+"/sample.txt");
		Stream<String> stream = Files.lines(path);
		
		try(Stream<String> lines = Files.lines(path)){
			lines.forEach(System.out::println);
		}
		
	}

	private static long countLenGreaterThanThree(List<String> list) {
		
		//return list.stream().filter( w -> w.length() > 3).count();
		//stream with lambda expression
		return list.parallelStream().filter( w -> w.length() > 3).count();
		
	}

	private static void sort2(String[] array) {

		Arrays.sort(array, String::compareToIgnoreCase);
		Arrays.stream(array).forEach(System.out::println);
	}

	private static void sort(String[] array) {

		Arrays.sort(array, (first, second) -> Integer.compare(first.length(), second.length()));
	}

}
