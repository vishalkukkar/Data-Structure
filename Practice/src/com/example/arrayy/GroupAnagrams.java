package com.example.arrayy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class GroupAnagrams {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		String[] array = { "eat", "tea", "tan", "ate", "nat", "bat" };
		String[] array2 = {"duh","ill"};
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(groupAnagrams(array2)));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> list = new ArrayList<>();
		Map<Integer, List<String>> map = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			String temp = strs[i];
			int index = 0;
			for (int j = 0; j < temp.length(); j++) {
				index = index + (int) temp.charAt(j) - 'a';
			}
			
			System.out.println("temp "+temp+" index "+index);

			if (map.containsKey(index)) {
				List<String> subList = map.get(index);
				subList.add(temp);
				map.put(index, subList);
			} else {
				List<String> subList = new ArrayList<>();
				subList.add(temp);
				map.put(index, subList);
			}
		}

		list.addAll(map.values());
		return list;

	}

}
