package com.example.dp;

//https://leetcode.com/problems/coin-change-2/description
// amount = 5, coins = [1, 2, 5]
//formula amount[j] += amount[amount - coin ]; 
public class CoinChangeProblem {

	public static void main(String[] args) {
		int amount = 12;
		int[] coins = { 1, 2, 5 };
		System.out.println(change(amount, coins));
	}

	public static int change(int amount, int[] coins) {

		int[] array = new int[amount + 1];
		array[0] = 1;
		for (int coin : coins) {
			for (int j = 1; j < array.length; j++) {
				if (j >= coin) {
					array[j] += array[j - coin];
				}
			}
		}
		return array[amount];
	}

}
