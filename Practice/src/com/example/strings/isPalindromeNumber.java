package com.example.strings;

public class isPalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}

	public static boolean isPalindrome(int x) {

		if (x < 0)
			return false;

		int res = 0;
		int temp = x;
		while (x > 0) {

			res = res * 10 + (x % 10);
			x = x / 10;
		}
		
		return res == temp;
	}

}
