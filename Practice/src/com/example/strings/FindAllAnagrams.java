package com.example.strings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> list = new FindAllAnagrams().findAnagrams(s, p);
		list.forEach(System.out::print);

	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (p == null && s == null)
			return null;

		int size = s.length();

		int endIndex = p.length();
		int beginIndex = 0;

		while (endIndex <= size) {

			if (IsAnagram(s.substring(beginIndex, endIndex), p)) {
				res.add(beginIndex);
			}
			beginIndex++;
			endIndex++;
		}
		return res;

	}

	private boolean IsAnagram(String string1, String string2) {

		char[] array1 = string1.toCharArray();
		char[] array2 = string2.toCharArray();

		int[] ans = new int[26];

		for (int i = 0; i < array2.length; i++) {

			ans[array1[i] - 'a']++;
			ans[array2[i] - 'a']--;
		}

		for (int i = 0; i < ans.length; i++) {
			if (ans[i] != 0)
				return false;
		}

		return true;
	}

}
