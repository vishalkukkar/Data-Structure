package com.example.dp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/*count of pairs which gives the sum to target
like 2+5 =7
is one pair 
and 3+4 = 7 another
so count is 2 for below array
{2,5,3,4,6}
when target is 7
*/
public class TwoSUm {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		int[] array = {2,5,3,4,6};
		ObjectMapper m = new ObjectMapper();
		System.out.println(m.writeValueAsString(twoSumMap(array, 7)));
	}

	public static List<List<Integer>> twoSumMap(int[] nums, int target) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			
			if (map.containsKey(nums[i])) {
				List<Integer> temp = map.get(nums[i]);
				List<Integer> temp2 = new ArrayList<Integer>();
				temp2.add(i);
				temp2.add(temp.get(0));
				list.add(temp2);
				temp.remove(0);
				map.put(nums[i], temp);

			} else {
				if (map.containsKey(target - nums[i])) {
					List<Integer> index = map.get(target - nums[i]);
					index.add(i);
					map.put(target - nums[i], index);
				} else {
					List<Integer> index = new ArrayList<>();
					index.add(i);
					map.put(target - nums[i], index);
				}
			}
		}
		return list;
	}
	/*public static int[] twoSum(int[] nums, int target) {

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
*/
}
