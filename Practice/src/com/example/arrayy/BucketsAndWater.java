package com.example.arrayy;

public class BucketsAndWater {

	public static void main(String[] args) {
		
		System.out.println(calc(24, 4, 6));

	}

	public static float calc(int waterQuantity, int cupSize, int nthCup) {
		float[] m = new float[nthCup];
		m[0] = waterQuantity;

		int level = 1;
		for (int i = 0, j = 0; i < m.length; i++, j++) {
			if (j == level) {
				j = 0;
				level++;
			}

			if (m[i] > cupSize) {
				float remainingWater = m[i] - cupSize;
				m[i] = cupSize;

				float h = remainingWater / 2;
				int leftIdx = i + level;
				int rightIdx = i + level + 1;
				if (leftIdx < m.length)
					m[leftIdx] += h;
				if (rightIdx < m.length)
					m[rightIdx] += h;

				// System.out.print(String.format(">>> %s, %s, %s, %s\n", i,
				// leftIdx, rightIdx, h));
			}
		}

		return m[nthCup - 1];
	}
}
