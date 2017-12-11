package com.example.maths;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class PascalsTriangle {

	public static void main(String[] args) {
		ObjectMapper o = new ObjectMapper();
		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> res = new ArrayList<>();

		if (numRows == 0)
			return res;

		List<Integer> l = new ArrayList<>();
		l.add(1);
		res.add(l);
		if (numRows == 1)
			return res;

		int count = 0;
		for (int i = 1; i < numRows; i++) {
			List<Integer> sub = new ArrayList<>();
			if (i == 1) {
				sub.add(1);
				sub.add(1);
				res.add(sub);
				count++;
			} else {
				int size = res.get(count).size();
				sub.add(1);
				List<Integer> temp = res.get(count);

				for (int j = 1; j < size; j++) {
					int sum = temp.get(j) + temp.get(j - 1);
					sub.add(sum);
				}
				sub.add(1);
				res.add(sub);
				count++;

			}
		}
		return res;

	}
}
