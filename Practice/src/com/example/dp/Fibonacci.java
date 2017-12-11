package com.example.dp;

public class Fibonacci {

	public static void main(String[] args) {

		// System.out.println("enter the max value ");
		// int val = new Scanner(System.in).nextInt();
		// getFibonacci(val);
		System.out.println(climbStairs(5));
		// recursiveFibo(10);
	}

	private static int climbStairs(int n) {

		int n1 = 0;
		int n2 = 1;

		if (n == 0 || n == 1)
			return n;

		int sum = 0;
		for (int i = 2; i <= n; i++) {
			sum = n1 + n2;
			n1 = n2;
			n2 = sum;

		}
		return sum;
	}

	private static int getFibo(int n) {

		if (n == 0 || n == 1)
			return n;

		return getFibo(n - 1) + getFibo(n - 2);
	}

	private static void getFibonacci(int max) {

		//
		int prev = 1;
		int curr = 1;
		int add = 0;

		System.out.print(add + " \n" + prev + " \n" + curr + "\n");
		for (int i = 0; i < max; i++) {
			add = prev + curr;
			prev = curr;
			curr = add;
			System.out.println(add);
		}
	}

}
