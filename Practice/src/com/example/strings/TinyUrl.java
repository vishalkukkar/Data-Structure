package com.example.strings;

import java.util.HashMap;

public class TinyUrl {

	public static void main(String[] args) {

		System.out.println(encode("https://leetcode.com/problems/design-tinyurl"));
	}

	HashMap<String,String> map = new HashMap<>();
	
	// Encodes a URL to a shortened URL.
	public static String encode(String longUrl) {
		String string = "http://tinyurl.com/";
		String url = longUrl.substring(longUrl.lastIndexOf("/") + 1, longUrl.length());
		System.out.println(url);
		return longUrl;

	}

	// Decodes a shortened URL to its original URL.
	public static String decode(String shortUrl) {
		return shortUrl;

	}

}
