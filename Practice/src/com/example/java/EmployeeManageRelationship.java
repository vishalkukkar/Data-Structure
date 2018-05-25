package com.example.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class EmployeeManageRelationship {

	static Map<String, Integer> result = new HashMap<String, Integer>();

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		Map<String, String> dataSet = new HashMap<String, String>();
		dataSet.put("A", "C");
		dataSet.put("B", "C");
		dataSet.put("C", "F");
		dataSet.put("D", "E");
		dataSet.put("E", "F");
		dataSet.put("F", "F");

		populateResult(dataSet);
		System.out.println("result = " + result);

	}

	private static void populateResult(Map<String, String> dataSet)
			throws JsonGenerationException, JsonMappingException, IOException {

		Map<String, List<String>> relations = new HashMap<>();

		for (Map.Entry<String, String> entry : dataSet.entrySet()) {

			
			if(entry.getKey().equals(entry.getValue())) continue;
			if (relations.containsKey(entry.getValue())) {
				List<String> temp = relations.get(entry.getValue());
				temp.add(entry.getKey());
				relations.put(entry.getValue(), temp);
			} else {
				List<String> temp = new ArrayList<>();
				temp.add(entry.getKey());
				relations.put(entry.getValue(), temp);
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(relations));

		for (Map.Entry<String, List<String>> entry : relations.entrySet()) {
			relationHelper(entry.getKey(), relations);
		}

		System.out.println(mapper.writeValueAsString(result));

	}

	private static int relationHelper(String key, Map<String, List<String>> relations) {

		int count = 0;
		if (!relations.containsKey(key)) {
			result.put(key, 0);
			return 0;
		} else if (result.containsKey(key)) {
			count = result.get(key);
		} else {
			List<String> empl = relations.get(key);
			count = empl.size();

			for (String e: empl) 
				count += relationHelper(e, relations);
			result.put(key, count);
			
		}
		return count;
	}

}
