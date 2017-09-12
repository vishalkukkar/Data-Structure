package com.cake.com;

public class StocksMaxProfit {

	public static void main(String[] args) {

		int[] stockPricesYesterday = new int[] { 10, 7, 5, 8, 11, 9 };
		System.out.println(getMaxProfit(stockPricesYesterday));
	}

	public static int getMaxProfit(int[] stock) {

		int minPrice = stock[0];
		int maxProfit = stock[1] - stock[0];

		for (int i = 1; i < stock.length; i++) {
			
			int currPrice = stock[i];
			int pottentialProfit = currPrice - minPrice;
			
			maxProfit = Math.max(maxProfit, pottentialProfit);
			minPrice = Math.min(minPrice, currPrice);
			
		}
		return maxProfit;
		
	}
}
