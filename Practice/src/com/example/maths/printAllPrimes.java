package com.example.maths;

import java.util.Arrays;

public class printAllPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] array = printPrimes(234);
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if(!array[i]){
				System.out.println(i);
				count++;
			}
				
		}
		
		System.out.println("count "+count);
	}

	private static boolean[] printPrimes(int max) {
		boolean[] array = new boolean[max + 1];
		int prime = 2;

		while (prime < Math.sqrt(max)) {

			crossFlags(prime, array);
			prime = getNextPrime(prime, array);
		}

		return array;
	}

	private static int getNextPrime(int prime, boolean[] array) {

		int next = prime + 1;
		while (next < array.length && array[next]) {
			next++;
		}

		return next	;

	}

	private static void crossFlags(int prime, boolean[] array) {
		for (int i = prime * prime; i < array.length ; i += prime) {
			array[i] = true;
		}

	}

}
