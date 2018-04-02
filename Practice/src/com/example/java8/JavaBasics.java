package com.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class JavaBasics {

	public static void main(String[] args) {
		Object o = new Object();
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String s = iter.next();

			if (s.equals("a")) {
				iter.remove();
			}
		}

		
		list.forEach(System.out::println);
	}

}
