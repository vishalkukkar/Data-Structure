package com.example.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	Map<Character, TrieNode> children;
	Boolean endOfWord;

	public TrieNode() {
		this.children = new HashMap<Character, TrieNode>();
		this.endOfWord = false;
	}
}
