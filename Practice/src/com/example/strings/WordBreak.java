package com.example.strings;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public class WordBreak {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		String string = "leetcode";
		Set<String> list = new HashSet<>();
		list.add("leet");
		list.add("code");
		System.out.println(wordBreak(string, list));
	}

	public static boolean wordBreak(String s, Set<String> dict) {

		boolean[] flag = new boolean[s.length() + 1];
		flag[0] = true;

		for (int i = 0; i < s.length(); i++) {

			if (flag[i] == true) {

				for (String word : dict) {

					int currIndex = i + word.length();

					if (currIndex > s.length())
						continue;

					if (s.substring(i, currIndex).equals(word))
						flag[currIndex] = true;
				}
			}
		}
		return flag[s.length()];
	}
}
