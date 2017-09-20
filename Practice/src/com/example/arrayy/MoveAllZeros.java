package com.example.arrayy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MoveAllZeros {

	public static void main(String[] args) {
		
		int[] array = {1,0,0,0,3,4,5};
		moveArray(array);
	}

	private static void moveArray(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] != 0){
				array[count] = array[i];
				count++;
			}
		}
		
		
		for (int i = count; i < array.length; i++) {
			array[i] = 0;
		}
		System.out.println(count);
		System.out.println(Arrays.toString(array));
	}

}
