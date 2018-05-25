package com.example.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/*
 * 				1
 * 			1		1
 * 		1		2		1
 * 	 1  	3		3		1		
 */

public class pascalsTriangle {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(generate(6)));

	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		
		for (int i = 0; i < numRows; i++) {
			row.add(0,1);
			for (int j = 1; j < row.size() - 1; j++) 
				row.set(j, row.get(j) + row.get(j + 1));
			allrows.add(new ArrayList<>(row));
		}
		
		return allrows;
	}

}
