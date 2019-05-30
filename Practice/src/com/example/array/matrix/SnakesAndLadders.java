package com.example.array.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

	public int snakesAndLadders(int[][] board) {

		int n = board.length;
		int[] array = new int[n * n];

		int i = n - 1;
		int j = 0;
		int index = 0;
		int incr = 1;

		while (index < n * n) {
			array[index++] = board[i][j];

			if (incr == 1 && j == n - 1) {
				incr = -1;
				i--;
			} else if (incr == -1 && j == 0) {
				incr = 1;
				i--;
			} else {
				j += incr;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n * n];
		int start = array[0] > -1 ? array[0] - 1 : 0;
		queue.add(start);
		visited[start] = true;
		int step = 0;
		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int k = 0; k < size; k++) {

				int curr = queue.poll();
				if(curr == n * n - 1) return step;
				
				for (int x = curr + 1; x <= Math.min(n * n - 1,curr + 6); x++) {
					int dest = array[x] > -1 ? array[x] - 1 : x;
					if(!visited[dest]){
						queue.offer(dest);
						visited[dest] = true;
					}
				}
				
			}
			step++;
		}

		return -1;

	}

	public static void main(String[] args) {
		int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
		System.out.println(new SnakesAndLadders().snakesAndLadders(board));

	}

}
