package com.example.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ConnectedComponents {

	public static void main(String[] args) {

		int[][] edges = { { 0, 1 }, { 2, 3 }, { 1, 2 } };
		System.out.println(new ConnectedComponents().countComponents(5, edges));
	}

	public int countComponents(int n, int[][] edges) {

		if (n == 0)
			return 0;

		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		System.out.println(Arrays.deepToString(edges));

		Map<Integer, Integer> map = new HashMap<>();
		int count = 1;
		map.put(edges[0][0], edges[0][0]);
		map.put(edges[0][1], edges[0][1]);
		for (int i = 1; i < edges.length; i++) {
			int[] array = edges[i];

			if (!map.containsKey(array[0]) && !map.containsKey(array[0]))
				count++;
			map.put(array[0], array[0]);
			map.put(array[1], array[1]);
		}
		return count;
	}
}
