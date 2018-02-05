package com.example.strings;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class LetterCombinationOfString {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		List<String> list = letterCombinations("23");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(list));
	}

	public static List<String> letterCombinations(String digits) {
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		LinkedList<String> queue = new LinkedList<>();
		queue.add("");
		for (int i = 0; i < digits.length(); i++) {
			int num = Integer.parseInt("" + digits.charAt(i));
			char[] array = mapping[num].toCharArray();

			int size = queue.size();
			for (int j = 0; j < size; j++) {
				String temp = queue.remove();
				for (int k = 0; k < array.length; k++) {
					queue.add(temp + array[k]);
				}
			}
		}
		return queue;
	}

}
