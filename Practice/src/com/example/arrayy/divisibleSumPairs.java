package com.example.arrayy;

import java.util.HashMap;
import java.util.Map;

public class divisibleSumPairs {

	public static void main(String[] args) {

		int n = 6;
		int k = 3;

		int[] ar = { 1, 3, 2, 6, 1, 2 };
		System.out.println(divisibleSumPairs(n, k, ar));
	}

	public static int divisibleSumPairs(int n, int k, int[] ar) {

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		
		
		
		for (int i = 0; i < n; i++) {

			if(map.containsKey(ar[i])){
				
			}else{
				
			}
		}

		return k;
	}
}
