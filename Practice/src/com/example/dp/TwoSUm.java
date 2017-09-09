package com.example.dp;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSUm {

	public static void main(String[] args) {

		int[] array = { 2, 11, 15,7 };
		System.out.println(Arrays.toString(twoSumMap(array, 9)));
	}
	
	
	public static int[] twoSumMap(int[] nums, int target) {
		
		int[] result = new int[2];
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	
		for (int i = 0; i < nums.length; i++) {
			
			
			if(map.containsKey(nums[i])){
				result[0] = map.get(nums[i]);
				result[1] = i;
				return result;
				
			}else{
				map.put(target - nums[i], i);
			}
			
		}
		return result;
	}
	

	public static int[] twoSum(int[] nums, int target) {

		int val = 0;
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			val = nums[i];
			result[0] = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (val + nums[j] == target) {
					result[1] = j;
					return result;
				}
			}
		}

		return null;

	}

}
