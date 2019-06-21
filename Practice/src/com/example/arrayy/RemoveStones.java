package com.example.arrayy;

import java.util.HashSet;
import java.util.Set;

import com.util.Util;

/**
 * 
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]] Output: 5
 ****/
public class RemoveStones {

	public static void main(String[] args) {

		int[][] stones = { { 0, 1 }, { 1, 0 } };
		System.out.println(new RemoveStones().removeStones(stones));

	}

	public int removeStones(int[][] stones) {

		if (stones == null || stones.length == 0)
			return 0;

		Set<Integer> x = new HashSet<>();
		Set<Integer> y = new HashSet<>();

		x.add(stones[0][0]);
		y.add(stones[0][1]);
		

		int move = 0;

		for (int i = 1; i < stones.length; i++) {

			int[] a = stones[i];
   
			if (x.contains(a[0]))
				move++;
			else if (y.contains(a[1]))
				move++;

			x.add(a[0]);
			x.add(a[1]);
		}

		return move;

	}

}
