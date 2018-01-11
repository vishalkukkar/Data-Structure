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
		LinkedList<String> ans = new LinkedList<>();
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int num = Integer.parseInt("" + digits.charAt(i));
			char[] array = mapping[num].toCharArray();
			while (ans.peek().length() == i) {
				String temp = ans.remove();
				for (int j = 0; j < mapping[num].toCharArray().length; j++) {
					ans.add(temp + array[j]);
				}
			}
		}
		return ans;
	}

}
