package com.example.arrayy;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class FindDuplicateInVectorOfIntegers {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		vector.add(1);
		vector.add(2);
		vector.add(2);
		vector.add(3);
		vector.add(4);
		vector.add(5);

		
		//removing it using 
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0 ; i < vector.size(); i++) {
			if (map.containsKey(vector.get(i)))
				vector.remove(i);
			else
				map.put(vector.get(i),vector.get(i));
		}

		for (Integer i : vector) {
			System.out.println(i);
		}
	}

}
