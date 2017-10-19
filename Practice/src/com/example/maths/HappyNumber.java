package com.example.maths;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {

		System.out.println(isHappy(19));

	}

	public static boolean isHappy(int n) {

		Set<Integer> set = new HashSet<>();
		set.add(n);
		while(true){
			int num = getNumber(n);
			
			if (num == 1)
				return true;
			
			if(set.contains(num))
				return false;
		
			set.add(num);
			n = num;
		}
	}
	
	public static Integer getNumber(int n){
		
		int number = 0;
		while (n > 0) {
			number = number + (n % 10) * (n % 10);
			n = n / 10;
		}
		System.out.println(number);
		
		return number;
	}
}
