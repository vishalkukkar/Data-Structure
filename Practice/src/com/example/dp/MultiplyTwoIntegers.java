package com.example.dp;

public class MultiplyTwoIntegers {

	public static void main(String[] args) {
		System.out.println(multiply(7, -7));
	}

	private static int multiply(int i, int j) {

		return multiplyNumbers(i, j);
	}

	private static int multiplyNumbers(int small, int big) {

		if (big == 0)
			return 0;
		 if (big > 0)
			return (small + multiplyNumbers(small, big - 1));
		if(big < 0)
			return -multiplyNumbers(small,-big);
		
		return big;

	}

}
