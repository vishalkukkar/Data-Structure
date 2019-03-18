package com.example.dp;

import java.util.HashMap;
import java.util.Map;

import com.util.Util;

//https://leetcode.com/problems/coin-change-2/description
// amount = 5, coins = [1, 2, 5]
//formula amount[j] += amount[amount - coin ]; 
public class CoinChangeProblem {

	public static void main(String[] args) {
		int amount = 11;
		int[] coins = { 1,2,5 };
		System.out.println(coinChange(coins, amount));
	}

	public static int coinChange(int[] coins, int amount) {

		if (coins == null || coins.length == 0 || amount <= 0)
			return 0;

		Map<Integer,Integer> map = new HashMap<>();
		int res =  minimumCoinTopDown(amount, coins,map);

		System.out.println(Util.print(map));
		return res;
	}

	
	public static int minimumCoinTopDown(int total, int coins[], Map<Integer, Integer> map) {

        //if total is 0 then there is nothing to do. return 0.
        if ( total == 0 ) {
            return 0;
        }

        //if map contains the result means we calculated it before. Lets return that value.
        if ( map.containsKey(total) ) {
            return map.get(total);
        }

        //iterate through all coins and see which one gives best result.
        int min = Integer.MAX_VALUE;
        for ( int i=0; i < coins.length; i++ ) {
            //if value of coin is greater than total we are looking for just continue.
            if( coins[i] > total ) {
                continue;
            }
            //recurse with total - coins[i] as new total
            int val = minimumCoinTopDown(total - coins[i], coins, map);

            //if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
            if( val < min ) {
                min = val;
                System.out.println(coins[i]);
            }
        }

        //if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
        min =  (min == Integer.MAX_VALUE ? min : min + 1);

        //memoize the minimum for current total.
        map.put(total, min);
        return min;
    }

	public static int change(int amount, int[] coins) {
		
		
		int[][] res = new int[coins.length][amount + 1];
		
		
		for (int i = 1; i < res.length; i++) {
			for (int j = 1; j < res[0].length; j++) {
				
				if(j > res[i][j]){
					Math.min(res[i - 1][j],
							1 + res[i][j - coins[i]]);
				else{
						
					}
				}
			}
		}
		
		return res[coins.length - 1][amount];
		
	}

}
