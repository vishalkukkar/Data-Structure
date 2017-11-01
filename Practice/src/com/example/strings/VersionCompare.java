package com.example.strings;

import java.util.Arrays;

public class VersionCompare {

	public static void main(String[] args) {
		System.out.println(compareVersion("1", "1.1"));

	}

	public static int compareVersion(String version1, String version2) {
		if (version1 == null || version2 == null)

			if (version1.equalsIgnoreCase(version2))
				return 0;
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		String[] v3 = v2;
		if (v1.length > v2.length) {
			// create new v3 for v2
			// array v2 ----> v3
			int diff = (v1.length - v2.length);
			v3 = new String[v2.length + diff];
			for (int i = 0; i < v2.length + diff; i++) {

				if (i >= v2.length) {
					v3[i] = "0";
				} else
					v3[i] = v2[i];
			}
		}

		String[] v4 = v1;
		if (v2.length > v1.length) {
			// create new v4 for v1
			// array v1 ----> v4
			int diff = (v2.length - v1.length);
			v4 = new String[v1.length + diff];
			for (int i = 0; i < v1.length + diff; i++) {
				if (i >= v1.length) {
					v4[i] = "0";
				} else
					v4[i] = v1[i];
			}
		}
//		System.out.println("v1 " + Arrays.toString(v4));
//		System.out.println("v2 :" + Arrays.toString(v3));

		for (int i = 0; i < v3.length; i++) {

			int val1 = Integer.parseInt(v4[i]);
			int val2 = Integer.parseInt(v3[i]);

			if (val1 == val2)
				continue;

			if (val1 > val2)
				return 1;
			else
				return -1;
		}

		return 0;

	}
}
