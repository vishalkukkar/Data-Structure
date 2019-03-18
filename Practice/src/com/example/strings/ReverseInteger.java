package com.example.strings;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(Integer.MAX_VALUE));
		int i = (746384741 - 1) / 10;
		
		
		System.out.println((746384741 * 10) + 1);
	}

	public static int reverse(int x) {
		int result = 0; // container for result
		while (x != 0) {

			int lastDigit = x % 10;

			// find the num
			int num = (result * 10) + lastDigit;
			// check the number\\
			
			System.out.println(result + "   "+(num - lastDigit) / 10 +"      num "+num+"             last digit "+lastDigit);
			if ((num - lastDigit) / 10 != result) {
				return 0;
			}

			result = num;
			x = x / 10;

		}
		return result;

	}

	public static int reverse1(int x) {

		// check if valid integer
		if (x < Integer.MIN_VALUE)
			return 0;
		if (x > Integer.MAX_VALUE)
			return 0;

		Long temp = Long.valueOf(x);
		Long result = 0l;

		// check if is negative number
		// make it positive
		Boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			temp = temp + (temp * -1) + (temp * -1);
		}

		while (temp != 0) {
			Long lastDigit = temp % 10;
			result = 10 * result + lastDigit;
			temp = temp / 10;

		}

		// add negative sign if no is negative
		if (isNegative) {
			result = -1 * result;
			if (result < Integer.MIN_VALUE)
				return 0;
		}

		if (result > Integer.MAX_VALUE)
			return 0;

		return Integer.valueOf(result + "");
	}

}
