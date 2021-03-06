package com.example.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * 
 * @author vkukkar
 *
 *         https://leetcode.com/problems/most-common-word/description/
 *
 *         Given a paragraph and a list of banned words, return the most
 *         frequent word that is not in the list of banned words. It is
 *         guaranteed there is at least one word that isn't banned, and that the
 *         answer is unique.
 * 
 *         Words in the list of banned words are given in lowercase, and free of
 *         punctuation. Words in the paragraph are not case sensitive. The
 *         answer is in lowercase.
 * 
 *         Example: Input: paragraph = "Bob hit a ball, the hit BALL flew far
 *         after it was hit." banned = ["hit"] Output: "ball" Explanation: "hit"
 *         occurs 3 times, but it is a banned word. "ball" occurs twice (and no
 *         other word does), so it is the most frequent non-banned word in the
 *         paragraph. Note that words in the paragraph are not case sensitive,
 *         that punctuation is ignored (even if adjacent to words, such as
 *         "ball,"), and that "hit" isn't the answer even though it occurs more
 *         because it is banned.
 * 
 * 
 *         Note:
 * 
 *         1 <= paragraph.length <= 1000. 1 <= banned.length <= 100. 1 <=
 *         banned[i].length <= 10. The answer is unique, and written in
 *         lowercase (even if its occurrences in paragraph may have uppercase
 *         symbols, and even if it is a proper noun.) paragraph only consists of
 *         letters, spaces, or the punctuation symbols !?',;. Different words in
 *         paragraph are always separated by a space. There are no hyphens or
 *         hyphenated words. Words only consist of letters, never apostrophes or
 *         other punctuation symbols.
 *
 */
public class MostCommonWord {

	public static void main(String[] args) {
		String[] array = { "a" };
		System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", array));
	}

	public static String mostCommonWord(String paragraph, String[] banned) {

		if (paragraph == null || paragraph.length() == 0)
			return null;

		String word = null;
		int max = 0;
		String[] array = paragraph.trim().toLowerCase().split("\\W+");
		
		System.out.println(Arrays.toString(array));
		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();

		for (String s : banned)
			set.add(s);

		for (String s : array) {

			if (set.contains(s))
				continue;

			if (map.containsKey(s)) {
				int val = map.get(s) + 1;

				if (val > max) {
					max = val;
					word = s;
				}

			} else {

				map.put(s, 0);

				if (max == 0)
					word = s;
			}
		}

		return word;
	}
	/*
	 * public static String mostCommonWord(String paragraph, String[] banned) {
	 * 
	 * Map<String,Integer> words = new HashMap<>(); String res = null; String[]
	 * input = paragraph.toLowerCase().split("[',.?!;]* ");
	 * 
	 * for(String word : input) words.put(word, words.getOrDefault(word, 0) +
	 * 1); for(String b : banned) words.remove(b); for(String word :
	 * words.keySet()) if(res == null || words.get(word) > words.get(res)) res =
	 * word; return res;
	 * 
	 * }
	 */
}
