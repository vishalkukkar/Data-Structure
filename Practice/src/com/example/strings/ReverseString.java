package com.example.strings;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {

		String string = "helloo";
		System.out.println(reverseString(string));
	}

	private static String reverseString(String s) {

		char[] array = new char[s.length()];
		int i = 0;
		int n = s.length();
		int j = n - 1;
		while (i <= n / 2 && j >= n / 2) {
			array[j] = s.charAt(i);
			array[i] = s.charAt(j);

			i++;
			j--;
		}
		StringBuilder sb = new StringBuilder();
		for (int j2 = 0; j2 < array.length; j2++) {
			sb.append(array[j2]);
		}
		return sb.toString();
	}

}
