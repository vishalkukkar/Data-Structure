package com.example.strings;

public class MultiplyStrings {

	public static void main(String[] args) {

		String num1 = "456";
		String num2 = "123";

		System.out.println(" ans "+multiply(num1, num2));
	}

	public static String multiply(String num1, String num2) {

		if (num1 == null || num2 == null)
			return null;

		String first = null;
		String second = null;

		if (num1.length() > num2.length()) {
			first = num1;
			second = num2;
		} else {
			first = num2;
			second = num1;
		}

		int[][] matrix = new int[first.length()][first.length() * 2];

		int f1 = first.length() - 1;
		int f2 = second.length() - 1;

		int zeros = 0;
		int carry = 0;
		for (int i = first.length() - 1; i >= 0; i--) {
			if (f2 < 0)
				break;
			int temp = zeros;
			Integer x = second.charAt(f2) - '0';

			for (int j = (first.length() * 2) - 1; j >= 0; j--) {

				if (temp != 0) {
					temp--;
					continue;
				}

				if (f1 < 0){
					if(carry > 0){
						matrix[i][j] = carry;
					}
					break;
				}

				Integer y = first.charAt(f1) - '0';
				
				int multi = (x * y) + carry;
				matrix[i][j] = multi % 10;
				carry = multi / 10;
				f1--;

			}
			f1 = first.length() - 1;
			f2--;
			carry = 0;
			zeros++;
		}
		
		
		//System.out.println(Arrays.deepToString(matrix));

		StringBuilder sb = new StringBuilder();
		int c = 0;
		int col = (first.length() * 2) - 1;
		while (col >= 0) {
			Integer temp = 0;
			for (int i = first.length() - 1; i >= 0; i--) {
				temp += matrix[i][col];
			}
			temp = temp + c;
			c = temp / 10;
			int add = temp % 10;
			sb.append(add);
			col--;
		}

		String temp = sb.toString();
		int l = 0;
		while(l < temp.length()){
			if(temp.charAt(l) == '0')
				l++;
			else
				break;
		}
		
		if(l == sb.length())
			return "0";
		return sb.reverse().toString().replaceFirst("^0*", "");

	}

}
