package com.example.arrayy;

import java.util.Arrays;
import java.util.Stack;

// left left
//right right
// right left
// left right

public class AsteroidCollision {

	public static void main(String[] args) {

		int[] asteroids = {10,-10};
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));
	}

	public static int[] asteroidCollision(int[] asteroids) {
		if (asteroids.length < 2) {
			return asteroids;
		}

		int curr = 1;
		int prev = 0;
		while (curr < asteroids.length) {
			if (prev == -1) {
				asteroids[0] = asteroids[curr];
				prev = 0;
				curr++;
				continue;
			} else {
				if (asteroids[prev] > 0 && asteroids[curr] < 0) {
					if (Math.abs(asteroids[prev]) == Math.abs(asteroids[curr])) {
						prev--;
						curr++;
					} else if (Math.abs(asteroids[prev]) > Math.abs(asteroids[curr])) {
						curr++;
					} else {
						prev--;
					}
				} else {
					prev++;
					asteroids[prev] = asteroids[curr];
					curr++;
				}
			}
		}
		
		System.out.println(Arrays.toString(asteroids));
		System.out.println("prev"+prev);

		return Arrays.copyOf(asteroids, prev + 1);
	}

}
