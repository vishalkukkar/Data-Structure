package com.example.maths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class SteppingNumber {



	// Prints all stepping numbers reachable from num
	// and in range [n, m]
	public static void bfs(int n, int m, int num) {
		// Queue will contain all the stepping Numbers
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(num);

		while (!q.isEmpty()) {
			// Get the front element and pop from
			// the queue
			int stepNum = q.poll();

			// If the Stepping Number is in
			// the range [n,m] then display
			if (stepNum <= m && stepNum >= n) {
				System.out.print(stepNum + " ");
			}

			// If Stepping Number is 0 or greater
			// then m ,need to explore the neighbors
			if (stepNum == 0 || stepNum > m)
				continue;

			// Get the last digit of the currently
			// visited Stepping Number
			int lastDigit = stepNum % 10;

			// There can be 2 cases either digit
			// to be appended is lastDigit + 1 or
			// lastDigit - 1
			int stepNumA = stepNum * 10 + (lastDigit - 1);
			int stepNumB = stepNum * 10 + (lastDigit + 1);

			// If lastDigit is 0 then only possible
			// digit after 0 can be 1 for a Stepping
			// Number
			if (lastDigit == 0)
				q.add(stepNumB);

			// If lastDigit is 9 then only possible
			// digit after 9 can be 8 for a Stepping
			// Number
			else if (lastDigit == 9)
				q.add(stepNumA);

			else {
				q.add(stepNumA);
				q.add(stepNumB);
			}
		}
	}

	// Prints all stepping numbers in range [n, m]
	// using BFS.
	public static void displaySteppingNumbers(int n, int m) {
		// For every single digit Number 'i'
		// find all the Stepping Numbers
		// starting with i
		for (int i = 0; i <= 9; i++)
			bfs(n, m, i);
	}

	// Driver code
	public static void main(String args[]) {
		int n = 560, m = 570;

		// Display Stepping Numbers in
		// the range [n,m]
		displaySteppingNumbers(n, m);
		
		steppingNumber(n,m);
	}

	private static void steppingNumber(int n, int m) {
		
		for (int i = 0; i < 10; i++) {
			display(n,m,i);
		}
		
	}

	private static void display(int n, int m, int num) {
		
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(num);
		
		if(num >= n && num <= m)
			System.out.print(num+" ");
		
		while(!queue.isEmpty()){
			Integer x = queue.remove();
			
			if(n == 0 || x > m )
				continue;
				
			int lastDigit = x % 10;
			
			//plus one minus one
			int left = 10 * x + lastDigit - 1;
			int right = 10 * x + lastDigit + 1;
			
			if(lastDigit == 0){
				queue.add(right);
			}else if(lastDigit == 9){
				queue.add(left);
			}
			else{
				queue.add(left);
				queue.add(right);
			}
		}
		
	}
}
