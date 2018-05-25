package com.example.sort;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class WordScore {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		String[] array = { "this","this","vishal","this"};
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(sortWordByScore(array)));
	}

	private static String[] sortWordByScore(String[] words) {

		Map<String, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < words.length; i++) {
			map.put(words[i], getScore(words[i]));
		}

		Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		int i = 0;
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			words[i] = entry.getKey();
			i++;
		}

		return words;
	}
	
	private static Integer getScore(String input) {
		if (input == null || input.length() == 0)
			return 0;

		char[] array = input.toLowerCase().toCharArray();
		int score = 1;
		for (int i = 0; i < array.length; i++) {

			if (array[i] == 'a' || array[i] == 'e' || array[i] == 'i' || array[i] == 'o' || array[i] == 'u')
				score += 1 + ((int) array[i] - 'a') * 2;
			else
				score += 1 + ((int) array[i] - 'a');

		}
		return score;
	}

}
