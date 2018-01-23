package com.example.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSequence {

	public static void main(String[] args) {

		// System.out.println(lengthOfLongestSubstring("abcab"));
		char[] c = new char[26];
		String sample = "vishal";
		for (int i = 0; i < sample.length(); i++) {
			System.out.println(sample.charAt(i) - 'a');
			c[sample.charAt(i) - 'a']++;
		}
		System.out.println(new String(c));

	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return ans;
	}

}
