package com.example.maths;

public class IsPrime {

	public static void main(String[] args) {
		System.out.println(isPrime(37));
	}

	public static Boolean isPrime(int n) {

		if (n < 2)
			return false;

		int sqrt = (int) Math.sqrt(Double.valueOf(n));
		System.out.println(sqrt);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0)
				return false;
		}

		return true;

	}
}
