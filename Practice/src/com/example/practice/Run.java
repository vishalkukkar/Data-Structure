package com.example.practice;

class Run {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		int[] input1 = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int[] res = new Run().hash_and_store(input1);
		for (int i : res)
			System.out.print(" " + i);
		
		System.out.println("\n");
		int[] input2 = { 1,4, 8,25,38,23,19,49,21,44};
		int[] res1 = new Run().hash_and_store(input2);
		for (int i : res1)
			System.out.print(" " + i);
		
	}

	public int[] hash_and_store(int[] input) {

		int[] bucket = new int[10];
		for (int i = 0; i < 10; i++)
			bucket[i] = Integer.MAX_VALUE;

		for (int i = 0; i < input.length; i++) {

			int j = input[i] % 10;
			int pos = 0;

			if (bucket[j] == Integer.MAX_VALUE) {
				bucket[j] = input[i];
			} else {
				// recalculate hash
				int temp = input[i];

				while (temp != 0) {
					int rightMost = temp % 10;
					temp = temp / 10;

					if (temp == 0)
						break;

					int newJ = temp % 10;

					if (rightMost % 2 == 0) {
						pos = j - newJ;

					} else {
						pos = j + newJ;
					}

					if (pos < 0) {
						pos = pos + 10;
					} else if(pos >= 10){
						pos = pos - 10;
					}

					if (bucket[pos] == Integer.MAX_VALUE) {
						bucket[pos] = input[i];
						break;
					}
				}

				// didn't find bucket move sequentially
				if (temp == 0) {
					while (pos < input.length && bucket[pos] != Integer.MAX_VALUE) {
						pos++;
						if (pos >= input.length)
							pos = 0;
					}

					if (pos >= input.length)
						throw new IllegalAccessError();

					bucket[pos] = input[i];
				}
			}
		}

		return bucket;
	}
}
