package com.example.strings;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

	public static void main(String[] args) {
		System.out.println(new RestoreIPAddress().restoreIpAddresses("25525511135"));

	}

	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();

		for (int a = 0; a <= 3; a++) {
			for (int b = 0; b <= 3; b++) {
				for (int c = 0; c <= 3; c++) {
					for (int d = 0; d <= 3; d++) {

						if (a + b + c + d == s.length()) {

							String aString = s.substring(0, a);
							String bString = s.substring(a, a + b);
							String cString = s.substring(a + b, a + b + c);
							String dString = s.substring(a + b + c, a + b + c + d);

							if (Integer.valueOf(aString) > 255 || Integer.valueOf(bString) > 255
									|| Integer.valueOf(cString) > 255 || Integer.valueOf(dString) > 255)
								continue;

							if ((aString.length() > 1 && aString.startsWith("0"))
									|| (bString.length() > 1 && bString.startsWith("0"))
									|| (cString.length() > 1 && cString.startsWith("0"))
									|| (dString.length() > 1 && dString.startsWith("0")))
								continue;
							
							  String str = aString + "." + bString + "." + cString  + "." + dString;
							  res.add(str);

						}
					}
				}

			}
		}

		return res;

	}
}
