package com.example.maths;

public class ArmstrongNumber {

	public static void main(String[] args) {
		
		for (int i = 0; i < 1000; i++) {
			if(isArmSrongNumber(i))
			System.out.println(i);
		}

	}

	public static boolean isArmSrongNumber(int i) {

		int number = i;
		int result = 0;
		int value = 0;
		
		while(number > 0){
			
			value = number % 10;
			number = number / 10;
			result = (int) (result + Math.pow(value, 3));
		}
		
		return result == i;
	}

}
