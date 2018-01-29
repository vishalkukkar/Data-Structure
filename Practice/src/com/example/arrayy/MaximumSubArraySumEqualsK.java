package com.example.arrayy;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * https://www.programcreek.com/2014/10/leetcode-maximum-size-subarray-sum-equals-k-java/
 * @author vkukkar
 *Example 1:
 *Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 */

public class MaximumSubArraySumEqualsK {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		int[]  nums = {1, -1, 5, -2, 3};
		int k = 3;
		
		System.out.println(maxSubArrayLen(nums,k));

	}

	public static int maxSubArrayLen(int[] nums, int k) throws JsonGenerationException, JsonMappingException, IOException {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	 
	    int max = 0;
	    int sum=0;
	    
	    for(int i=0; i<nums.length; i++){
	        sum += nums[i];
	 
	        if(sum==k){
	            max = Math.max(max, i+1);
	        }  
	 
	        int diff = sum-k;
	 
	        System.out.println("sum "+sum+" diff"+diff);
	        
	        if(map.containsKey(diff)){
	            max = Math.max(max, i-map.get(diff));
	        }
	 
	        if(!map.containsKey(sum)){
	            map.put(sum, i);
	        }
	    }
	 
	 
	    ObjectMapper mapper = new ObjectMapper();
	    System.out.println(mapper.writeValueAsString(map));
	    
	    return max;
	}

}
