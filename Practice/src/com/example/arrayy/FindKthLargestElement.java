package com.example.arrayy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargestElement {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 1, 2, 56, 33, 12, 88, 81, 22, 45, 58 };
		
		int k = 4;
		System.out.println(findKthLargest(nums, k));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(nums[nums.length-k]);
	}

	public static int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int n : nums) {
			queue.offer(n);
			if (queue.size() > k)
				queue.poll();
		}
		return queue.peek();
	}
}
