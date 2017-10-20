package com.example.dp;

public class HouseRobber {

	// https://leetcode.com/problems/house-robber/description/
	public static void main(String[] args) {

		int[] array = {50,1,1,50};
		System.out.println(rob(array));
	}

	public static int rob(int[] nums) {

		int even = 0;
		int odd = 0;

		for (int i = 0; i < nums.length; i++) {
			
			if(i % 2 == 0){
				even = even + nums[i];
				even = even > odd ? even:odd;
			}else{
				odd = odd + nums[i];
				odd = even > odd ? even:odd;
			}
		}
		return even > odd ? even:odd;
	}

}
