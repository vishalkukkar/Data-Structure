package com.example.strings;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(123));
	}

	public static int reverse(int x) {

		//check if valid integer
		if(x <  Integer.MIN_VALUE)
			return 0;
		if(x > Integer.MAX_VALUE)
			return 0;
			
		
		Long temp = Long.valueOf(x);
		Long result = 0l;
		
		//check if is negative number
		//make it positive
		Boolean isNegative = false;
		if(x < 0){
			isNegative = true;
			temp = temp + (temp * -1) + (temp * -1);
		}
		
		while(temp != 0){
			Long lastDigit = temp % 10;
			result = 10 * result + lastDigit;
			temp = temp / 10;

		}
		
		//add negative sign if no is negative
		if(isNegative){
			result = -1 * result;
			if(result < Integer.MIN_VALUE)
				return 0;
		}
		
		
		if(result > Integer.MAX_VALUE)
			return 0;
		
		return Integer.valueOf(result+"");
	}

}
