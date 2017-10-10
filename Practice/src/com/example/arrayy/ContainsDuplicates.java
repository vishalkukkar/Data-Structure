package com.example.arrayy;

import java.util.ArrayList;
import java.util.List;

public class ContainsDuplicates {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 1 };
		System.out.println(containsDuplicates(a));
	}

	static boolean containsDuplicates(int[] a) {

		List<Integer> map = new ArrayList<Integer>();

		for (int i = 0; i < 0; i++) {
			System.out.println(a[i]+" a[i]");
			if (map.contains(a[i])) {
				return true;
			} else {
				map.add(a[i]);
			}
		}

		return false;
	}

}
