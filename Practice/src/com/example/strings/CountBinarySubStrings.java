package com.example.strings;

public class CountBinarySubStrings {

	public static void main(String[] args) {
		
		System.out.println(new CountBinarySubStrings().countBinarySubstrings("00110011"));
	}

	public int countBinarySubstrings(String s) {

		char[] array = new char[s.length()];
		int count = 0;
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {

			count += getCount(i, i + 1, n, array);

		}

		return count;
	}

	// "00110011"
	public int getCount(int i, int j, int len, char[] array) {

		int count = 0;

		while (i >= 0 && j < len) {

			if (array[i] == '0' && array[j] == '1') {
				count++;
				i--;
				j++;
			} else
				break;

		}

		return count;

	}
}
