package com.example.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AscdendingFrequency {

	public static void main(String[] args) {
		int[] arr = { 3,1,2,2,4 };
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
			System.out.println(" key " + m.getKey() + " value " + m.getValue());
		}

		for (Map.Entry<Integer, Integer> m : sortedMap.entrySet()) {
			int count = m.getValue();
			while (count > 0) {
				System.out.println(m.getKey());
				count--;
			}
		}

	}

	public static TreeMap<Integer, Integer> sortMapByValue(HashMap<Integer, Integer> map) {
		Comparator<Integer> comparator = new ValueComparator(map);
		// TreeMap is a temp sorted by its keys.
		// The comparator is used to sort the TreeMap by keys.
		TreeMap<Integer, Integer> result = new TreeMap<Integer, Integer>(comparator);
		result.putAll(map);
		return result;
	}
}

class ValueComparator implements Comparator<Integer> {

	HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();

	public ValueComparator(HashMap<Integer, Integer> map) {
		this.temp.putAll(map);
	}

	@Override
	public int compare(Integer s1, Integer s2) {
		if (temp.get(s1) > temp.get(s2))
			return 1;
		else if (temp.get(s1) < temp.get(s2))
			return -1;
		else
			return 1;

	}
}
