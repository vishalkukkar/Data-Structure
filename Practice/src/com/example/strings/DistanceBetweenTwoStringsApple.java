package com.example.strings;

/*
* To execute Java, please define "static void main" on a class
* named Solution.
*
* If you need more classes, simply define them inline.
*/
class DistanceBetweenTwoStringsApple {
	public static void main(String[] args) {

		//// minDistance(dog, fox) => 2
		// minDistance(fox, dog) => 2
		String input = "Fox blah jumped over blah. blah Dog";
		System.out.println(minDistance(input, "fox", "dog"));
	}

	public static int minDistance(String input, String word1, String word2) {

		// null check

		String[] array = input.split("\\s");
		Integer min = Integer.MAX_VALUE;
		Integer distance = 0;
		boolean firstFound = false;
		boolean secondFound = false;
		String str = null;
		int index1 = 0;
		int index2 = 0;

		for (int i = 0; i < array.length; i++) {

			str = array[i];

			if (str.equalsIgnoreCase(word1)) {

				firstFound = true;
				index1 = i;

				if (secondFound) {

					distance = index1 > index2 ? (index1 - index2 - 1) : (index2 - index1 - 1);
				}
			}

			if (str.equalsIgnoreCase(word2)) {
				secondFound = true;
				index2 = i;

				if (firstFound) {
					distance = index1 > index2 ? (index1 - index2 - 1) : (index2 - index1 - 1);
				}
				
			}

			if (firstFound && secondFound)
				min = Math.min(min, distance);

		}

		return min == Integer.MAX_VALUE ? -1 : min;

	}
}
