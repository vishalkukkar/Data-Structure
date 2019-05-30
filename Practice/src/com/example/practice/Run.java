package com.example.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Run {

	public static void main(String[] args) {

		Map<String, Object> map = new HashMap<>();

		String str = "1234";
		List<String> list = Arrays.asList(new String[] { "abbcacccccc", "abcseabcccc" });
		System.out.println(findDuplicate(list));
	}

	static String findDuplicate(List<String> ss) {

		int[] idx = new int['z' - 'a' + 1];
//		for (int i = 0; i < idx.length; i++)
//			idx[i] = -1;

		int[] localIdx = new int['z' - 'a' + 1];
		for (String s : ss) {
				localIdx = new int['z' - 'a' + 1];

			for (int i = 0; i < s.length(); i++)
				localIdx[s.charAt(i) - 'a']++;
			for (int j = 0; j < localIdx.length; j++)
				idx[j] = idx[j] == 0 ? localIdx[j] : Math.min(idx[j], localIdx[j]);
		}

		String r = "";
		for (int i = 0; i < idx.length; i++) {
			if(idx[i] == 0) continue;
			for (int j = 0; j < idx[i]; j++)
				r += String.valueOf((char) ('a' + i));
		}

		return r;
	}

}
