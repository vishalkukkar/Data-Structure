package com.example.arrayy;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		
		int[] height = {1,1};
		System.out.println(new ContainerWithMostWater().maxArea(height));
		System.out.println(new ContainerWithMostWater().getMaxRainwaterBetweenTowers(height));

	}
	
	public static int getMaxRainwaterBetweenTowers(int[] towerHeight) {
        int maxSeenSoFar = 0;
 
        int[] maxSeenRight = new int[towerHeight.length];
        int maxSeenLeft = 0;
 
        int rainwater = 0;
 
        for (int i = towerHeight.length - 1; i >= 0; i--) {
            if (towerHeight[i] > maxSeenSoFar) {
                maxSeenSoFar = towerHeight[i];
                maxSeenRight[i] = maxSeenSoFar;
            } else {
                maxSeenRight[i] = maxSeenSoFar;
            }
        }
 
        for (int i = 0; i < towerHeight.length; i++) {
            rainwater = rainwater + Integer.max(Integer.min(maxSeenLeft, maxSeenRight[i]) - towerHeight[i], 0);
            if (towerHeight[i] > maxSeenLeft) {
                maxSeenLeft = towerHeight[i];
            }
        }
 
        return rainwater;
    }

	public int maxArea(int[] height) {

		if (height == null)
			return 0;

		int[] rightSideHeight = new int[height.length];
		int maxRight = 0;
		int leftMax = 0;
		int maxArea = 0;


		for (int i = height.length - 1; i >= 0; i--) {

			if (height[i] > maxRight) {
				maxRight = height[i];
			}
			rightSideHeight[i] = maxRight;
		}

		for (int j = 0; j < height.length - 1; j++) {

			maxArea = maxArea + 
					Integer.max(0, Integer.min(leftMax, rightSideHeight[j]) - height[j]);

			if (height[j] > leftMax)
				leftMax = height[j];
		}

		return maxArea;

	}

}
