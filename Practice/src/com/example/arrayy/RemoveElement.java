package com.example.arrayy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * Example 1:
 * 
 * Given nums = [3,2,2,3], val = 3, [2,2,3,3] i j 2 2 2 3
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 * 
 */
public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int[] nums2 = {3,2,2,3};
		System.out.println(new RemoveElement().removeElement(nums, 2));
		System.out.println(new RemoveElement().removeElement(nums2, 3));
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(nums2));
		
		List<Integer> l = new ArrayList<>();
		l.addAll(new ArrayList<>(l));
	}

	public int removeElement(int[] nums, int val) {

		int i = 0;
		int j = 0;

		while ( j < nums.length) {

			if (nums[i] == val && nums[j] == val) {
				j++;
			} else if (nums[i] == val && nums[j] != val) {
				swap(i, j, nums);
				i++;
			} else{
				i++;
				j++;
			}
		}
		return i;

	}

	public void swap(int i, int j, int[] nums) {

		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
