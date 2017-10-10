package com.example.arrayy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class TwoSumTwoArrays {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		int[] a = { 1, 2, 3 }, b = { 10, 20, 30, 40 };
		ObjectMapper m = new ObjectMapper();
		// System.out.println(m.writeValueAsString(twoSumMap(array, 7)));
//		System.out.println(twoSumMapCount(array, 7));
//		System.out.println(twoSumWithoutSort(array, 7));
	}

	public static Boolean twoSum(int[] a, int[] b, int v) {

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(v - a[i]);
		}

		for (int i = 0; i < b.length; i++) {
			if (set.contains(b[i]))
				return true;
		}
		return false;

	}

}
