package com.example.practice;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	public static class TrieNode {

		Map<Character, TrieNode> children = null;
		Boolean endOfWord = null;

		TrieNode() {
			this.children = new HashMap<>();
			this.endOfWord = false;
		}
	}

	TrieNode root = new TrieNode();

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abcd");
		trie.insert("bcd");

		System.out.println(trie.search("bc"));
		System.out.println(trie.startsWith("bc"));

	}

	/** Initialize your data structure here. */
	public Trie() {

	}

	/** Inserts a word into the trie. */
	public void insert(String word) {

		if (word == null || word.length() == 0)
			return;

		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {

			char c = word.charAt(i);
			TrieNode node = current.children.get(c);
			if (node == null) {
				node = new TrieNode();
				current.children.put(c, node);
			}
			current = node;
		}

		current.endOfWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {

		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = curr.children.get(c);
			if (node == null)
				return false;
			curr = node;
		}

		return curr.endOfWord;

	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {

		if (prefix == null)
			return false;

		int count = prefix.length();
		TrieNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			
			TrieNode node = curr.children.get(prefix.charAt(i));
			
			if(node == null)
				break;
			curr = node;
			count--;
		}
		return count == 0;

	}
}
