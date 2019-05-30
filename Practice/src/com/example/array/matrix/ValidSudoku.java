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
		
		System.out.println("valid sudoku");
	}
	
	private static boolean isValidSudoku2(char[][] board){
		
		if (board == null || board.length == 0 || board.length != 9)
			return false;
		
		
		for (int i = 0; i < board.length; i++) {
			
			boolean row[] = new boolean[9];
			boolean col[] = new boolean[9];
			boolean box[] = new boolean[9];
			
			
			for (int j = 0; j < board[0].length; j++) {
				
				//row
				if(board[i][j] == '.' || board[j][i] == '.') 
					continue;
			
				int ch1 = board[i][j] - '1';
				if(row[ch1]){
					return false;
				}else{
					row[ch1] = true;
				}
				
				//column
				int ch2 = board[j][i] - '1';;
				if(col[ch2]){
					return false;
				}else{
					col[ch2] = true;
				}
				
				//box
				
				int x = 3 * (i / 3) + (j / 3);
				int y = 3 * (i % 3) + (j % 3);
				
				if(board[x][y] == '.')
					continue;
				
				//column
				int ch3 = board[x][y] - '1';
				if(box[ch3]){
					return false;
				}else{
					box[ch3] = true;
				}
				
				
				
			}
			
		}
		return true;
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
