package com.example.linkedlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SubSetI {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		ObjectMapper m = new ObjectMapper();
		int[] array = { 1,2,3};
		// List<List<Integer>> result = getSubsets(list);
		System.out.println(m.writeValueAsString(getSubsets(array)));

	}

	private static List<List<Integer>> getSubsets(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();

	
				
		for (int i = 0; i < nums.length; i++) {

			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

			for (List<Integer> t : result) {
				temp.add(new ArrayList<Integer>(t));
			}

			for (ArrayList<Integer> b : temp) {
				b.add(nums[i]);
			}

			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(nums[i]);
			temp.add(single);
			result.addAll(temp);
		}

		//add empty set
		result.add(new ArrayList<Integer>());
		return result;

	}
}
