package com.example.dp;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {

	public static void main(String[] args) {

		int[] nums = { 1,1,1,0 };

		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums) {

		if (nums == null || nums.length == 0)
			return false;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		int len = nums.length - 1;

		while (!queue.isEmpty()) {

			int index = queue.remove();
			
			System.out.println(index + " "+ len);
			if (nums[index] >= (len - index)) {
				return true;
			} else {

				int t = index;
				for (int j = 0; j < nums[index]; j++) {
					if (t + 1 <= len) {
						queue.add(t + 1);
						t++;
					}
				}
			}

		}
		return false;

	}
}
