package com.example.repeats;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class threeSumRepeat {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		int[] array = { -1, 0, 1, 2, -1, -4 };
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(threeSum(array)));
	}

	private static List<List<Integer>> threeSum(int[] array) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(array);

		for (int i = 0; i < array.length - 1; i++) {

			int j = i + 1;
			int k = array.length - 1;

			while (j < k) {

				if (array[i] + array[j] + array[k] == 0) {
					List<Integer> l = new ArrayList<>();
					l.add(array[i]);
					l.add(array[j]);
					l.add(array[k]);
					res.add(l);
					
					j++;
					k--;

				} else if (array[i] + array[j] + array[k] > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return res;
	}

}
