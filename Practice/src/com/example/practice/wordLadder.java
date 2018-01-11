package com.example.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
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

		LinkedList<String> queue = new LinkedList<>();
		wordList.add(endWord);
		queue.add(beginWord);
		int count = 1;
		while (!queue.isEmpty()) {

			String curr = queue.remove();
			if (curr.equals(endWord))
				return count;

			char[] array = curr.toCharArray();

			for (int i = 0; i < array.length; i++) {
				char temp = array[i];
				for (char j = 'a'; j < 'z'; j++) {

					if (j != temp) {
						array[i] = j;
					}

					String str = new String(array);
					if (wordList.contains(str)) {
						queue.offer(str);
						wordList.remove(str);
					}
				}

				array[i] = temp;
			}
			
			count = count + 1;

		}
		return 0;

	}

}
