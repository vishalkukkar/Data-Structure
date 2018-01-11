package com.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {

		String s = "aaaaaaa";
		List<String> dict = new ArrayList<>();
		dict.add("aaaa");
		dict.add("aaa");

		System.out.println(wordBreak(s, dict));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {

		boolean[] flag = new boolean[s.length() + 1];
		flag[0] = true;

		for (int i = 0; i < s.length(); i++) {

			if (flag[i] == true) {

				for (String word : wordDict) {

					int currIndex = i + word.length();
					if (currIndex > s.length())
						continue;

					if (s.substring(i, currIndex).equals(word)) {
						flag[currIndex] = true;
					}
				}
			}
		}

		return flag[s.length()];

	}
}
