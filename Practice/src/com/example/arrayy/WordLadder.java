package com.example.arrayy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

https://leetcode.com/problems/word-ladder/description/
 */
public class WordLadder {

	public static class wordNode {
		String word;
		int numSteps;

		wordNode(String word, int numSteps) {
			this.word = word;
			this.numSteps = numSteps;
		}
	}

	public static void main(String[] args) {
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		Set<String> list = new HashSet<>(Arrays.asList(words));
		System.out.println(ladderLength("hit", "cog", list));
	}

	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {

		LinkedList<wordNode> queue = new LinkedList<>();
		wordList.add(endWord);
		queue.add(new wordNode(beginWord, 1));

		while (!queue.isEmpty()) {

			wordNode wordNode = queue.remove();
			String word = wordNode.word;

			if (word.equalsIgnoreCase(endWord))
				return wordNode.numSteps;

			char[] array = word.toCharArray();
			for (int i = 0; i < array.length; i++) {
				char temp = array[i];
				for (char j = 'a'; j < 'z'; j++) {

					if (j != temp) {
						array[i] = j;
					}

					String string = new String(array);
					if (wordList.contains(string)) {
						System.out.println(wordNode.numSteps);
						queue.add(new wordNode(string, wordNode.numSteps + 1));
						wordList.remove(string);
					}
				}
				array[i] = temp;
			}
		}
		return 0;
	}
}
