package com.example.trie;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Trie {

	ObjectMapper mapper = new ObjectMapper();
	TrieNode root = new TrieNode();

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		System.out.println();

		String string1 = "search";
		// String string2 = "dad";
		// String string3 = "mad";
		Trie d = new Trie();
		d.insert(string1);
		// d.insert(string2);
		// d.insert(string3);
		// System.out.println(d.search("abcd"));
		// System.out.println(d.startsWith("bcpo"));

		String[] array = { "WordDictionary", "addWord", "addWord", "search", "search", "search", "search", "search",
				"search" };
		for (int i = 0; i < array.length; i++) {
			d.insert(array[i]);
		}

		String[] array2 = {"","a","a",".","a","aa","a",".a","a."};
		for (int i = 0; i < array2.length; i++) {
			System.out.println(d.advanceSearch(array[i]));
		}

	}

	private Boolean advanceSearch(String word) {

		TrieNode curr = root;

		LinkedList<TrieNode> queue = new LinkedList<>();
		queue.add(curr);
		int level = 0;
		int len = word.length() - 1;
		while (!queue.isEmpty() && level <= len) {

			char c = word.charAt(level);
			int size = queue.size();
			for (int i = 0; i < size; i++) {

				Map<Character, TrieNode> children = queue.remove().children;
				TrieNode temp = children.get(c);
				if (temp != null) {
					if (level == len && temp.endOfWord)
						return true;
					queue.add(temp);

				} else if (c == '.') {

					for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
						queue.add(entry.getValue());
					}
				} else
					return false;
			}
			level++;
		}
		return true;
	}

	private Boolean search(String word) {
		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode temp = curr.children.get(c);
			if (temp == null)
				return false;
			curr = temp;

		}
		return curr.endOfWord;
	}

	private void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			TrieNode node = current.children.get(c);

			if (node == null) {
				node = new TrieNode();
				current.children.put(c, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	private Boolean startsWith(String word) {

		if (word == null || word.length() == 0)
			return true;

		int count = 1;
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode temp = curr.children.get(c);
			if (temp != null && count == word.length()) {
				return true;
			}

			if (temp == null)
				return false;
			count++;
			curr = temp;
		}
		return false;
	}

}
