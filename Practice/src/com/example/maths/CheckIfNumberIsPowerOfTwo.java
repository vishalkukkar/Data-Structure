package com.example.maths;

public class CheckIfNumberIsPowerOfTwo {

	public static void main(String[] args) {
		
		System.out.println(printPowerOFTwo());
	}

	private static double printPowerOFTwo() {
		
		double n = 2;
		
		for (int j = 2; j < 10; j++) {
			System.out.println(n);
			n = Math.pow(2, j);
		}
		
		return n;
	}

}
