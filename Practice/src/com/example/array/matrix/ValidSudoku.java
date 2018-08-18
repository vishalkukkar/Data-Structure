package com.example.array.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {

		char[][] sudoku = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println(isValidSudoku2(sudoku));
	}

	private static boolean isValidSudoku2(char[][] board){
		
		if (board == null || board.length == 0 || board.length != 9)
			return false;
		
		for (int i = 0; i < board.length; i++) {
			
			Set<Integer> rows = new HashSet<>();
			Set<Integer> column = new HashSet<>();
			Set<Integer> cube = new HashSet<>();
			
			for (int j = 0; j < board.length; j++) {
				
				if(board[i][j] != '.' && !rows.add((int) board[i][j] - '1')) return false;
				if(board[j][i] != '.' && !column.add((int) board[j][i] - '1')) return false;
				
				int row = (i / 3 * 3) + j / 3;
				int col =  (i % 3 * 3) + j % 3;
				if(board[row][col] != '.' && !cube.add((int) board[row][col] - '1')) return false;
				
			}
		}
		return false;
	}

	private static boolean isValid(char[][] board) {

		if (board == null || board.length == 0 || board.length != 9)
			return false;

		// check for rows
		for (int i = 0; i < 9; i++) {
			boolean[] rows = new boolean[9];
			for (int j = 0; j < 9; j++) {

				if (board[i][j] != '.') {
					int num = board[i][j] - '1';
					if (rows[num])
						return false;
					else
						rows[num] = true;
				}
			}
		}

		// check for column
		for (int i = 0; i < 9; i++) {
			boolean[] rows = new boolean[9];
			for (int j = 0; j < 9; j++) {

				if (board[j][i] != '.') {
					int num = board[j][i] - '1';
					if (rows[num])
						return false;
					else
						rows[num] = true;
				}
			}
		}

		// check for 9 * 9 matrix
		for (int i = 0; i < 9; i++) {
			boolean[] rows = new boolean[9];
			for (int j = i / 3 * 3; j < i / 3 * 3 + 3; j++) {
				for (int k = i % 3 * 3; k < i % 3 * 3 + 3; k++) {

					if (board[j][k] != '.') {
						int num = board[j][k] - '1';
						if (rows[num])
							return false;
						else
							rows[num] = true;
					}
				}
			}
		}

		return false;
	}

}
