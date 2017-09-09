package com.example.strings;

public class StringToInteger {

	public static void main(String[] args) {

		System.out.println(myAtoi("-123"));
	}

	public static int myAtoi(String str) {

		if (str == null || str.length() == 0)
			return 0;

		str = str.trim();
		int i = 0;
		if (str.charAt(0) == '-')
			i++;
		else if (str.charAt(0) == '+')
			i++;

		double result = 0;

		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {

			result = result * 10 + (str.charAt(i) - '0');
			i++;

		}

		if (str.charAt(0) == '-')
			result = -result;

		// handle min max

		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) result;

	}

}
