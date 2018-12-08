package com.example.maths;

public class TrailingZeros {

	public static void main(String[] args) {
		
		System.out.println(trailingZeroes(10));
	}

	public static int trailingZeroes(int n) {

		if (n == 0)
			return 0;

		int fact = 1;
		int i = 1;
		fact = 0;
		while ( n != 0) {
			n = n / 5;
			fact += n;
		}

		return fact;
	}

}
