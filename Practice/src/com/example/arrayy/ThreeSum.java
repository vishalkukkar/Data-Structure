package com.example.arrayy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ThreeSum {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		int[] array = { -1, 0, 1, 2, -1, -4 };
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(threeSum(array)));
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return result;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {

			int j = i + 1;
			int k = nums.length - 1;

			if(i!= 0 && nums[i] == nums[i-1]){
				continue;
			}
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					result.add(temp);

					j++;
					k--;

					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;

				} else if (nums[i] + nums[j] + nums[k] < 0) {
					j++;
				} else {
					k--;
				}
			}
		}

		return result;

	}

}
