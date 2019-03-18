package com.example.array.matrix;

import java.util.Arrays;

import com.util.Util;

public class DungeonGame {

	public static void main(String[] args) {
		
		int[][] dungeon = { {-2,-3,3},
							{-5,-10,1},
							{10,30,-5}};
		System.out.println(new DungeonGame().calculateMinimumHP(dungeon));

	}

	public int calculateMinimumHP(int[][] dungeon) {
		
		if(dungeon == null || dungeon.length == 0)
			return 0;
		
		
		int sum = 0;
		int[][] memo = new int[dungeon.length][dungeon[0].length];
		
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[0].length; j++) {
				memo[i][j] = Integer.MIN_VALUE;
			}
		}
		
		System.out.println();
		
	   calculate(dungeon,memo,0,0);
	   System.out.println(Util.print(memo));
	   return memo[0][0];
        
    }

	private int calculate(int[][] dungeon, int[][] memo, int i, int j) {
		
		if(i < dungeon.length && j < dungeon.length){

		 if(i == dungeon.length - 1 && j == dungeon[0].length - 1)
			return dungeon[i][j];
		else			
			memo[i][j] = dungeon[i][j] + Math.max(calculate(dungeon, memo,i+1,j),
					calculate(dungeon, memo,i,j + 1));
		}
		return memo[0][0];
	}

}
