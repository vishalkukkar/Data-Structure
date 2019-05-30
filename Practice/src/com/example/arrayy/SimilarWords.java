package com.example.arrayy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimilarWords {

	public static void main(String[] args) {

		String[] words1 = { "great", "acting", "skills" };
		String[] words2 = { "fine", "drama", "talent" };
		String[][] pairs = { { "great", "fine" }, { "drama", "acting" }, { "skills", "talent" } };

		System.out.println(new SimilarWords().areSentencesSimilar(words1, words2, pairs));

	}

	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

		if (words1 == null || words2 == null)
			return true;
		if (words1.length != words2.length)
			return false;

		// get mappings
		Map<String, Set<String>> map = new HashMap<>();
		for (String[] str : pairs) {
			
			if(map.get(str[0]) == null) map.put(str[0], new HashSet<>());
			if(map.get(str[1]) == null) map.put(str[1], new HashSet<>());
			map.get(str[0]).add(str[1]);
			map.get(str[1]).add(str[0]);
		}

		for (int i = 0; i < words1.length; i++) {

			String x = words1[i];
			String y = words2[i];

			if (x.equals(y)) continue;
			if(!map.containsKey(x)) return false;
			if (!map.get(x).contains(y)) return false;;

		}

		return true;
	}

}
