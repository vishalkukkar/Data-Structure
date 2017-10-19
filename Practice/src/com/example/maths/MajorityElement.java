package com.example.maths;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/majority-element/description/
public class MajorityElement {

	public static void main(String[] args){
		int[] array = {1,1,1,1,1,1,1,1,22,3,2,2,2,2,22,1,2,2,2,2,2,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,44,4,4,4,44,4,44,4,4,4,4};
	}
	public int majorityElement(int[] nums) {
		Map<Integer,Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])){
				map.put(nums[i], map.get(nums[i]) + 1);
			}else{
				map.put(nums[i], 1L);
			}
		}
		
		for(Map.Entry<Integer,Long> m:map.entrySet()){
			if(m.getValue() > (nums.length/2))
				return m.getKey();
		}
		return 0;

	}
}
