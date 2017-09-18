package com.example.strings;

import java.lang.reflect.Array;

public class LongestCommonSubString {

	public static void main(String[] args) {

		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	public static int lengthOfLongestSubstring(String s) {

		int result = 0, start = 0;
		boolean[] flag = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (flag[c]) {

				result = Math.max(result, i - start);

				for (int j = start; j < i; j++) {
					if (c == s.charAt(j)) {
						start++;
						break;
					}
					flag[s.charAt(j)] = false;
					start++;
				}

			} else {
				flag[c] = true;
			}
		}

		result = Math.max(result, s.length() - start);

		return result;

	}

}
