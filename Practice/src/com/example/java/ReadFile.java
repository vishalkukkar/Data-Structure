package com.example.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws IOException {

		FileReader file = new FileReader("/users/vkukkar/desktop/BillingLogDetails.csv");
		BufferedReader br = new BufferedReader(file);
		while (br.readLine() != null) {

			System.out.println(br.readLine());
		}
	}

}
