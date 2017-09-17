package com.example.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AscdendingFrequency {

	public static void main(String[] args) {
		int[] arr = {8,5,5,5,5,1,1,1,4,4};
		customSort(arr);

	}

	static void customSort(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		int[] result = new int[arr.length];
		
		TreeMap<Integer, Integer> sortedMap = sortMapByValue(map);  
		for (Map.Entry<Integer, Integer> m : sortedMap.entrySet()) {
			int count = m.getValue();
			while(count > 0){
				System.out.println(m.getKey());
				count--;
			}
		}
			
	}
	
	public static TreeMap<Integer, Integer> sortMapByValue(HashMap<Integer, Integer> map){
		Comparator<Integer> comparator = new ValueComparator(map);
		//TreeMap is a map sorted by its keys. 
		//The comparator is used to sort the TreeMap by keys. 
		TreeMap<Integer, Integer> result = new TreeMap<Integer, Integer>(comparator);
		result.putAll(map);
		return result;
	}
}

class ValueComparator implements Comparator<Integer>{
	 
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
 
	public ValueComparator(HashMap<Integer, Integer> map){
		this.map.putAll(map);
	}
 
	@Override
	public int compare(Integer s1, Integer s2) {
		if(map.get(s1) >= map.get(s2)){
			return 1;
		}else{
			return -1;
		}	
	}
}
