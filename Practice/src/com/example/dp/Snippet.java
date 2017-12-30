package com.example.dp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Snippet {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		List<List<Integer>> res = new ArrayList<>();
		int[] a = { 1, 2, 3 };
		res = permutationOfString(a);

		System.out.println(new ObjectMapper().writeValueAsString(res));
		
	}

	public static List<List<Integer>> permutationOfString(int[] nums)
			throws JsonGenerationException, JsonMappingException, IOException {

		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());

		for (int i = 0; i < nums.length; i++) {

			Set<List<Integer>> currSet = new HashSet<>();
			for (List<Integer> res : result) {
				for (int j = 0; j < res.size() + 1; j++) {
					res.add(j, nums[i]);
					List<Integer> l = new ArrayList<>(res);
					res.remove(j);
					currSet.add(l);
				}
			}
			
			result = new ArrayList<List<Integer>>(currSet);
		}
		return result;

	}

	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num)
			throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());

		for (int i = 0; i < num.length; i++) {
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);
			System.out.println(new ObjectMapper().writeValueAsString(returnList));
		}

		return returnList;
	}
}
