package com.example.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionLabels {

	public static void main(String[] args) {

		int[] array = { 0, 1, 0, 1, 1, 0, 0, 1 };
		System.out.println(Arrays.toString(new PartitionLabels().prisonAfterNDays(array, 1000)));

	}

	public int[] prisonAfterNDays(int[] cells, int N) {
		Map<String, Integer> seen = new HashMap<>();
		while (N > 0) {
			int[] cells2 = new int[8];
			seen.put(Arrays.toString(cells), N--);
			for (int i = 1; i < 7; ++i)
				cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
			cells = cells2;
			System.out.println(Arrays.toString(cells));
			
			
			
			if (seen.containsKey(Arrays.toString(cells))) {
				int prev = seen.get(Arrays.toString(cells));
				System.out.println("prev" + prev);
				System.out.println(N);
				N = N % (prev - N);
				System.out.println(N);
				
			}
		}
		return cells;
	}
	
}
