package com.example.strings;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class strToJson {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		/*
		 * High level questions on multi-threading. Given a list of integers
		 * construct a String in JSON format using basic String operations.
		 */
		Integer[] array = { 1, 3, 4, 5 };
		List<Integer> list = Arrays.asList(array);
		ObjectMapper m = new ObjectMapper();
		System.out.println(m.writeValueAsString(list));
		System.out.println();

		System.out.println(getJsonString(list));
	}

	private static String getJsonString(List<Integer> list) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		list.forEach(i -> sb.append(i+","));
		sb.setLength(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

}
