package com.example.trie;

public class Trie {

	TrieNode root = new TrieNode();

	public static void main(String[] args) {

		String string1 = "abcd";
		String string2 = "bcd";
		Trie d = new Trie();
		d.insert(string1);
		d.insert(string2);
		// System.out.println(d.search("abcd"));
		System.out.println(d.startsWith("bcpo"));
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
			
			if(temp == null)
				return false;
			count++;
			curr = temp;
		}
		return false;
	}

}
