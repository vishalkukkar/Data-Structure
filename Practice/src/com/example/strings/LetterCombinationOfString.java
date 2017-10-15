package com.example.strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class LetterCombinationOfString {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {/*

		List<String> list = letterCombinations("23");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(list));
	*/}

	/*public static List<String> letterCombinations(String digits) {

		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tvu");
		map.put('9', "wxyz");
		map.put('0', "");
		List<String> list = new ArrayList<>();

	}*/

	private static List<String> getList(Map<Character, String> map, List<String> list, String digits) {

		if (digits.length() == 0)
			return list;
		else {

			for (int i = 0; i < digits.length(); i++) {

			}
		}
		return null;
	}

}
