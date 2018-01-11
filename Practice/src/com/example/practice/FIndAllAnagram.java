package com.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIndAllAnagram {

	public static void main(String[] args) {

		String s = "cbaebabacd";
		String p = "abc";

		System.out.println(findAnagrams(s, p));
	}

	public static List<Integer> findAnagrams(String s, String p) {

		if (s == null || p == null || s.length() == 0 || p.length() == 0)
			return new ArrayList<>();

		List<Integer> l = new ArrayList<>();

		int startIndex = 0;
		int endIndex = p.length();

		int[] array = new int[26];
		int[] loc = new int[p.length()];
		int index = 0;
		for (int i = 0; i < p.length(); i++) {
			array[p.charAt(i) - 'a']++;
			loc[index] = p.charAt(i) - 'a';
			index++;
		}

		System.out.println(Arrays.toString(loc));

		while (endIndex <= s.length()) {
			String str = s.substring(startIndex, endIndex);
			int[] temp = Arrays.copyOf(array, array.length);
			int[] locTemp = Arrays.copyOf(loc, loc.length);

			System.out.println(Arrays.toString(locTemp));

			System.out.println(Arrays.toString(temp));
			if (isAnagram(str, p, temp, locTemp)) {
				l.add(startIndex);
			}

			System.out.println("\n");

			startIndex++;
			endIndex++;
		}
		return l;

	}

	private static boolean isAnagram(String str, String p, int[] temp, int[] loc) {

		System.out.println(str.length());
		for (int i = 0; i < str.length(); i++) {
			temp[str.charAt(i) - 'a']--;
		}

		for (int i = 0; i < loc.length; i++) {
			if (temp[loc[i]] != 0)
				return false;
		}
		return true;
	}
}
