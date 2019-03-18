package com.example.maths;

/*Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
*/
public class PowOfX {

	public static void main(String[] args) {

		double x = 2.00000;
		int n = 5;
		System.out.println(myPow(x, n));
	}

	public static double myPow(double x, int n) {
		if (n < 0)
			return 1 / power(x, -n);
		return power(x, n);
	}

	static double power(double x, int n) {

		if (n == 0)
			return 1;
		double half = power(x, n / 2);
		System.out.println(half +"   "+n);
		if (n % 2 == 0){
			
			return half * half;
		}
		return x * half * half;
	}

	/*
	 * public static double myPow(double x, int n) {
	 * 
	 * if (n < 0) { x = 1 / x; n = -n; }
	 * 
	 * double ans = 1; for (int i = 0; i < n; i++) { ans *= x; } return ans;
	 * 
	 * }
	 */

}
