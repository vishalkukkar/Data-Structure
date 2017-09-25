package com.example.dp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		int[] array = { 2, 2,2,2,2,2,2,2,2,5,5,5,5 };
		// 2,3,3,4,5
		ObjectMapper m = new ObjectMapper();
		// System.out.println(m.writeValueAsString(twoSumMap(array, 7)));
		System.out.println(twoSumMapCount(array, 7));
		System.out.println(twoSumWithoutSort(array, 7));
	}

	// {2,2,5,5} 7
	public static int twoSumWithoutSort(int[] arr, int target) {
		Map<Integer, Integer> resMap = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			Integer diff = target - arr[i];// 5 2-1
			if (resMap.containsKey(arr[i])) {
				count++;
				int temp = resMap.get(arr[i]);
				temp--;
				if (temp <= 0) 
					resMap.remove(arr[i]);
				 else 
					resMap.put(arr[i], temp);
				
			} else {
				if (resMap.containsKey(diff))
					resMap.put(diff, resMap.get(diff) + 1);
				 else 
					resMap.put(diff, 1);
				

			}
		}
		return count;

	}

	// {2,2,3,4,5,5} 7
	public static Integer twoSumMapCount(int[] nums, int target) {

		Arrays.sort(nums);
		int i = 0, j = nums.length - 1, count = 0;
		while (i < j) {
			if (nums[i] + nums[j] == target) {
				count++;
				i++;
				j--;
			} else if (nums[i] + nums[j] < target)
				i++;
			else if (nums[i] + nums[j] > target)
				j--;
		}

		return count;
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

	public static int twoSum(int[] arr, int target) {
		Map<Integer, Integer> resMap = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			Integer diff = target - arr[i];
			if (resMap.containsKey(arr[i])) {
				count += resMap.get(diff);

			}
			if (!resMap.containsKey(resMap.get(arr[i]))) {
				resMap.put(arr[i], 0);
			}
			resMap.put(i, resMap.get(arr[i]));
		}
		return count;

	}
	/*
	 * public static int[] twoSum(int[] nums, int target) {
	 * 
	 * int val = 0; int[] result = new int[2];
	 * 
	 * for (int i = 0; i < nums.length; i++) { val = nums[i]; result[0] = i; for
	 * (int j = i + 1; j < nums.length; j++) { if (val + nums[j] == target) {
	 * result[1] = j; return result; } } }
	 * 
	 * return null;
	 * 
	 * }
	 */
}
