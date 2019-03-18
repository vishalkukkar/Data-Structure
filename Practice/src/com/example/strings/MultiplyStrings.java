package com.example.strings;

import java.util.Arrays;

public class MultiplyStrings {

	public static void main(String[] args) {

		String num1 = "123";
		String num2 = "456";

		// System.out.println(" ans "+multiply(num1, num2));
		System.out.println("ans " + multplyStrings(num1, num2));
	}

	private static String multplyStrings(String num1, String num2) {
		StringBuilder res = new StringBuilder();
		int len1 = num1.length();
		int len2 = num2.length();

		int size = len1 + len2;
		int[] array = new int[size];
		int carry = 0;
		int p1 = len1 + len2 - 1;
		for (int i = len1; i > 0; i--) {
			int t = p1;
		    carry = 0;
			for (int j = len2; j > 0; j--) {

				int n = num1.charAt(i - 1) - '0';
				int m = num2.charAt(j - 1) - '0';

				int mul = (m * n) + carry + array[t];
				carry = mul / 10;
				int val = mul % 10;

				array[t] = val;
				t--;
			}

			if (carry > 0){
				array[t] = carry;
			}
				
			
			
			System.out.println(Arrays.toString(array));
			p1--;
		}

		int i = 0;
		while (i < size) {
			if (array[i] != 0)
				break;
			i++;
		}

		while (i < size) {
			res.append(array[i]);
			i++;
		}
		return res.toString();
	}

	public static String multiply(String num1, String num2) {

		if (num1 == null || num2 == null)
			return null;

		String first = null;
		String second = null;

		if (num1.length() > num2.length()) {
			first = num1;
			second = num2;
		} else {
			first = num2;
			second = num1;
		}

		int[][] matrix = new int[first.length()][first.length() * 2];

		int f1 = first.length() - 1;
		int f2 = second.length() - 1;

		int zeros = 0;
		int carry = 0;
		for (int i = first.length() - 1; i >= 0; i--) {
			if (f2 < 0)
				break;
			int temp = zeros;
			Integer x = second.charAt(f2) - '0';

			for (int j = (first.length() * 2) - 1; j >= 0; j--) {

				if (temp != 0) {
					temp--;
					continue;
				}

				if (f1 < 0) {
					if (carry > 0) {
						matrix[i][j] = carry;
					}
					break;
				}

				Integer y = first.charAt(f1) - '0';

				int multi = (x * y) + carry;
				matrix[i][j] = multi % 10;
				carry = multi / 10;
				f1--;

			}
			f1 = first.length() - 1;
			f2--;
			carry = 0;
			zeros++;
		}

		// System.out.println(Arrays.deepToString(matrix));

		StringBuilder sb = new StringBuilder();
		int c = 0;
		int col = (first.length() * 2) - 1;
		while (col >= 0) {
			Integer temp = 0;
			for (int i = first.length() - 1; i >= 0; i--) {
				temp += matrix[i][col];
			}
			temp = temp + c;
			c = temp / 10;
			int add = temp % 10;
			sb.append(add);
			col--;
		}

		String temp = sb.toString();
		int l = 0;
		while (l < temp.length()) {
			if (temp.charAt(l) == '0')
				l++;
			else
				break;
		}

		if (l == sb.length())
			return "0";
		return sb.reverse().toString().replaceFirst("^0*", "");

	}

}
