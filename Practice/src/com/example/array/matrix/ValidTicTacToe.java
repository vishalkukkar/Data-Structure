package com.example.array.matrix;

public class ValidTicTacToe {

	public static void main(String[] args) {
		String[] board = {	"OXX",
							"XOX",
							"OXO"};
		System.out.println(new ValidTicTacToe().validTicTacToe(board));
	}
	
	/** O 1 2
	 *  3 4 5
	 *  6 7 8
	 */

	int[][] win =
			{{0,1,2}, 
			{3,4,5},
			{6,7,8},
			{0,3,6},
			{1,4,7},
			{2,5,8},
			{0,4,8},
			{2,4,6}};

	public boolean validTicTacToe(String[] board) {

		char[] input = getCharArray(board);
		int countO = 0;
		int countX = 0;

		for (char c : input) {

			if (c == 'X')
				countX++;
			else if (c == 'O')
				countO++;
		}
		
		System.out.println("O "+isWinner(input, 'O') + "  "+countO+" \n X "+ isWinner(input, 'X') + " " +countX );

		if (countO == countX + 1 || countO == countX) {

			if (isWinner(input, 'O')) {
				if (isWinner(input, 'X'))
					return false;
				return countO == countX;
			}

			if (isWinner(input, 'X'))
				return countX + 1 == countO;
			
			return true;
		}
		return false;

	}

	private boolean isWinner(char[] input, char c) {
		
		
		for (int i = 0; i < 8; i++) {
				
				if(input[win[i][0]] == c && 
						input[win[i][1]] == c &&
						input[win[i][2]] == c)
					return true;
		}
		
		return false;
	}

	private char[] getCharArray(String[] array) {
		
		char[] all = new char[9];
		int i = 0;
		for(String s  : array)
			for(char c : s.toCharArray()){
				all[i] = c;
				i++;
			}
		return all;
	}

}
