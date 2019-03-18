package com.example.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log","cog"] As one shortest transformation is "hit"
 * -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 *
 */
public class wordLadder {

	public static void main(String[] args) {

		String beginWord = "hit";
		String endWord = "cog";
		String[] array = { "hot", "dot", "dog", "lot", "log", "cog" };
		Set<String> wordList = new HashSet<>(Arrays.asList(array));

		System.out.println(ladderLength(beginWord, endWord, wordList));

	}

	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> set = new HashSet<>(wordList);

		return ladderlen(beginWord.toCharArray(), endWord.toCharArray(), set, 0);

	}

	public static int ladderlen(char[] beginWord, char[] endWord, Set<String> set, int count) {

		if (isEqual(beginWord, endWord))
			return count;

		for (int i = 0; i < beginWord.length; i++) {

			if (beginWord[i] == endWord[i])
				continue;

			char temp = beginWord[i];
			beginWord[i] = endWord[i];

			String s = getString(beginWord);			
			if (set.contains(s)) {
				count++;
				break;
			} else {
				beginWord[i] = temp;
			}
		}

		return ladderlen(beginWord, endWord, set, count);
	}

	private static String getString(char[] beginWord) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < beginWord.length; i++) {
			sb.append(beginWord[i]);
		}
		return sb.toString();
	}

	public static boolean isEqual(char[] beginWord, char[] endWord) {

		for (int i = 0; i < beginWord.length; i++) {
			if (beginWord[i] != endWord[i])
				return false;
		}

		return true;
	}

}
