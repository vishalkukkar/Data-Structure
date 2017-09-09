package com.example.strings;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		String string = "abcefabthce";

		//Map<Character, Integer> map = new HashMap<Character, Integer>();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < string.length(); i++) {
			if (map.containsKey(string.charAt(i))) {
				map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
			} else {
				map.put(string.charAt(i), 1);
			}
		}
		
		
		Integer min = Integer.MIN_VALUE;
//		for(Map.Entry<Character, Integer> m:map.entrySet()){
//		
//			if(m.getKey() == 'a')
//				map.re
//		
//		}
		
		Iterator<Character> it = map.keySet().iterator();

		while (it.hasNext())
		{
		  
		  if (it.next() == 'a')
		    it.remove();
		 }
		
		map.entrySet().forEach(System.out::println);
	}

}
