package com.example.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/sort-characters-by-frequency/description/
public class sortCharactersByFrequency {

	public static void main(String[] args) {
		String s = "tree";
		System.out.println(frequencySort(s));
	}

	public static String frequencySort(String s) {

		StringBuilder sb = new StringBuilder();
		char[] a = s.toCharArray();
		Map<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if(map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);
		}
		
		 // 1. Convert Map to List of Map
        List<Map.Entry<Character,Integer>> list =
                new LinkedList<Map.Entry<Character,Integer>>(map.entrySet());

        
		Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
			public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2){
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		for (Map.Entry<Character,Integer> entry : list) {
			if(entry.getValue() > 1){
				for (int i = 0; i < entry.getValue(); i++) {
					sb.append(entry.getKey());
				}
			}else{
				sb.append(entry.getKey());
			}
		}
		
		return sb.toString();
	}

}
