package com.example.practice;

public class Fibonacci {

	public static void main(String[] args) {

		/*int[] array = new int[7];
		array[0] = 0;
		System.out.println(fibonacci(6, array));
		
		int[] temp = {0,1,1,2,3,5,8,13,21};*/
		
		
		System.out.println(Integer.MAX_VALUE);
	}

	// 0 1 1 2 3 5 8 13
	private static int fibonacci(int i, int[] array) {

		if (i == 0 || i == 1)
			return i;
		else {

			int temp = array[i];

			if (temp == 0) {

				temp = fibonacci(i - 1, array) + fibonacci(i - 2, array);
				array[i] = temp;
			}

			return temp;
		}

	}

}
