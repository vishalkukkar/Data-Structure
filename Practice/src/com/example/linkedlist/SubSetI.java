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

	private static ArrayList<ArrayList<Integer>> getSubsets(int[] S) {

		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < S.length; i++) {

			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> t : result) {
				temp.add(new ArrayList<Integer>(t));
			}

			for (ArrayList<Integer> b : temp) {
				b.add(S[i]);
			}

			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(S[i]);
			temp.add(single);
			result.addAll(temp);
		}

		return result;

	}
}
