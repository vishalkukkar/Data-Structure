package com.example.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.util.Util;

public class TopKFrequestWords {

	public static void main(String[] args) {
		
		
		String[] words = {"work","work","work","work","happy","happy","happy","coding","tv","tv","abc"};
		System.out.println(Util.print(topKFrequent(words, 2)));

	}

	public static List<String> topKFrequent(String[] words, int k) {

		List<String> result = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i]))
				map.put(words[i], map.get(words[i]) + 1);
			else
				map.put(words[i], 1);
		}

		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() == a.getValue() ?
				a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
				pq.add(entry);
		}


		while(k > 0) {
			result.add(pq.poll().getKey());
			k--;
		}
	
		return result;
	}
}
