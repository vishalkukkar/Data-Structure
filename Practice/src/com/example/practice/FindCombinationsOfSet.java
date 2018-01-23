package com.example.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class FindCombinationsOfSet {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		int[] set = {1,2,3};
		System.out.println(new ObjectMapper().writeValueAsString(getCombinations(set)));
		System.out.println(new ObjectMapper().writeValueAsString(getLetterCombinations("23")));
	}

	private static List<String> getLetterCombinations(String string) {
		
		String[] array = {"0","1","abc","def","hij","klm","nop","qrst","uvw","xyz"};
		 LinkedList<String> res = new LinkedList<>();
		 res.add("");
		for (int i = 0; i < string.length(); i++) {
			String input = array[Integer.parseInt(""+string.charAt(i))];
			
			while(res.peek().length() == i){
				String temp = res.remove();
				for (int j = 0; j < input.length(); j++) {
					res.add(temp + input.charAt(j) );
				}
				
			}
		}
		
		return res;
	}

	private static List<List<Integer>> getCombinations(int[] set) throws JsonGenerationException, JsonMappingException, IOException {
		
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<Integer>());
		for (int i = 0; i < set.length; i++) {
			List<List<Integer>> result = new ArrayList<>();
			for (int j = 0; j < list.size(); j++) {
				for (int j2 = 0; j2 < list.get(j).size() + 1; j2++) {
					List<Integer> subList = list.get(j);
					subList.add(j2, set[i]);
					List<Integer> temp = new ArrayList<>(subList);
					result.add(temp);
					subList.remove(j2);
					
				}
			}
			list = new ArrayList<List<Integer>>(result);
		}
		return list;
	}

}
