package com.example.arrayy;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Permutations {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		int[] array = { 1, 2, 3 };
		System.out.println(new ObjectMapper().writeValueAsString(permute(array)));
	}

	public static ArrayList<ArrayList<Integer>> permute(int[] num) throws JsonGenerationException, JsonMappingException, IOException {
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list.add(new ArrayList<>());
		
		for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			int size = list.size();
			System.out.println(new ObjectMapper().writeValueAsString(list));
			
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> temp = list.get(j);
				for (int k = 0; k < temp.size() + 1; k++) {
					temp.add(k,num[i]);
					ArrayList<Integer> t2 = new ArrayList<>(temp);
					res.add(t2);
					temp.remove(k);
				}
			}
			
			list = res;
		}
		
		return list;
	}

}
