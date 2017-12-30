package com.example.sort;

import java.lang.instrument.Instrumentation;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class SparseArraySearch {

	private static Instrumentation instrumentation;
	public static void main(String[] args) {
		String[] array = { "at", "", "ball", "", "", "", "", "dad", "", "", "pg", "", "" };
		// 0 //5 //7 //9 //12

		long m1 = Runtime.getRuntime().freeMemory();
	    
		BitSet s = new BitSet();
		s.set(1);
		s.set(2);
		
		Set<String> set = new HashSet<>();
		
		//System.out.println(binarySearch(array, 0, array.length - 1, "ball"));
	}

	private static int binarySearch(String[] array, int start, int end, String key) {

		if (start > end)
			return -1;

		int mid = (start + end) / 2;

		if (array[mid].equals(key))
			return mid;

		// find mid
		if (array[mid].equals("")) {

			int left = mid - 1;
			int right = mid + 1;

			while (true) {

				if(left < start && right > end )
					return -1;
				
				if (!array[left].equals("") && left >= start) {
					mid = left;
					break;
				} else if (!array[right].equals("") && right <= end) {
					mid = right;
					break;
				}

				left--;
				right++;
			}
		}
		
		if(array[mid].equals(key))
			return mid;
		else if (array[mid].compareTo(key) == -1)
			return binarySearch(array, mid + 1, end, key);
		else
			return binarySearch(array, start, mid - 1, key);
	}

}
