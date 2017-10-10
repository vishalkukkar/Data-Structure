package com.example.arrayy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendlyWords {

	public static void main(String[] args) {

		String[] a = { "car", "cheating", "dale", "deal", "lead", "listen", "silent", "teaching" };
		System.out.println(friendlyWords(a));
	}

	static String[] friendlyWords(String[] input) {
		List<List<String>> list = new ArrayList<>();
		Map<Integer, List<String>> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			String temp = input[i];
			int index = 0;
			char[] a = new char[256];
			for (int j = 0; j < temp.length(); j++) {
				index = index + (int) temp.charAt(j) - 'a';
			}

			String s = new String(a);
			System.out.println("temp " + s);

			if (map.containsKey(index)) {
				map.get(index).add(temp);

			} else {
				List<String> subList = new ArrayList<>();
				subList.add(temp);
				map.put(index, subList);
			}
		}

		int count = 0;
		for (List<String> l : map.values()) {
			if (l.size() != 1) {
				count++;
			}
		}

		int count2 = 0;

		List<String> resList = new ArrayList<>();
		for (List<String> l : map.values()) {
			if (l.size() != 1) {
				count2 = count2 + l.size();
				list.add(l);
			}
			count2++;
		}

		Collections.sort(list, new Comparator<List<String>>() {
			public int compare(List<String> o1, List<String> o2) {
				return o1.get(0).compareTo(o2.get(1));
			}
		});

		String[] res = new String[count2];
		int c = 0;
		for (int i = 0; i < list.size(); i++) {
			List<String> temp = list.get(i);
			for (int j = 0; j < temp.size(); j++) {
				res[c] = temp.get(j);
				c++;
			}
			res[c] = "\n";
		}

		System.out.println(Arrays.toString(res));

		return res;
	}

}
