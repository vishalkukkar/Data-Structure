package com.example.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SearchDocs {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		String D1 = "I am software engineer";
		String D2 = "I am mechanical engineer but I love software love";
		String D3 = "I am engineer";

		List<String> list = new ArrayList<>();
		list.add(D1);
		list.add(D2);
		list.add(D3);

		Map<String, Integer> map = compressDocs(list);
		System.out.println(new ObjectMapper().writeValueAsString(map));

		System.out.println(search("engineer software", map));
		System.out.println(search("I love software", map));
	}

	private static Boolean search(String string, Map<String, Integer> map) {

		String[] temp = string.split("\\s");
		for (int i = 0; i < temp.length; i++) {
			if (map.get(temp[i]) == null)
				return false;
		}
		return true;
	}

	private static Map<String, Integer> compressDocs(List<String> list) {

		Map<String, Integer> result = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			String curr = list.get(i);
			String[] array = curr.split("\\s");

			for (int j = 0; j < array.length; j++) {
				if (i == 0) {
					result.put(array[j], 1);
				} else {

					Integer count = result.get(array[j]) == null ? null :
						result.get(array[j]);
					if (count != null && count == i) {
						result.put(array[j], i + 1);
					}

				}
			}

		}

		return result;
	}

}
