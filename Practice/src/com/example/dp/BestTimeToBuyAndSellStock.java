package com.example.dp;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {

		int[] array = { 7, 6, 4, 3, 1 };
		System.out.println(getBestPrice(array));
	}

	private static int getBestPrice(int[] array) {

		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			min = Math.min(array[i], min);

			// curr max
			int curr = array[i] - min;
			
			System.out.println("min "+min+" curr"+curr);
			if (curr > max)
				max = curr;

		}

		return max;
	}

}
