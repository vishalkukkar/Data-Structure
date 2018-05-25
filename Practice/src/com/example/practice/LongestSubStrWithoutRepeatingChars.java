package com.example.practice;

public class LongestSubStrWithoutRepeatingChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "abcdc";
		String sub = "wke";

		System.out.println(lengthOfLongestSubstring(string));
		//start 1 2 
	}

	public static int lengthOfLongestSubstring(String s) {

		boolean[] array = new boolean[256];
		int start = 0;
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (array[c]) {

				result = Math.max(result, i - start);

				for (int j = start; j < i; j++) {

					if (s.charAt(j) == c) {
						start++;
						break;
					}
					array[s.charAt(j)] = false;
					start++;

				}
			} else {
				array[s.charAt(i)] = true;
			}
		}

		return Math.max(result, s.length() - start);

	}

}
