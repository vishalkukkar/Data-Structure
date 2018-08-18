package com.example.maths;

/***
 * Write a recursive function to determine prime number   Find all primes less
 * than number
 * 
 * @author vkukkar
 *
 */
public class PrimeRecursive {

	public static void main(String[] args) {

		// int num = 13;
		// System.out.println(isPrime(num));
		System.out.println(countPrimes2(10));
		System.out.println(countPrimes(10));
	}

	private static int countPrimes2(int n) {

		if (n <= 2)
			return 0;

		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;

		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			if (primes[i]) {
				for (int j = i + i; j < n; j += i)
					primes[j] = false;
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}

		return count;
	}

	private static int countPrimes(int n) {

		if (n <= 2)
			return 0;

		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;

		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			if (primes[i]) {
				for (int j = i + i; j < n; j += i) {
					primes[j] = false;
				}
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}

		return count;
	}

	private static boolean isPrime(int num) {

		for (int i = 2; i < 13; i++) {

			if (num % i == 0)
				return false;
		}

		return true;
	}

}
