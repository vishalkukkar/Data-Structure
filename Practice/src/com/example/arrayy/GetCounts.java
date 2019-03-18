package com.example.arrayy;

public class GetCounts {

	int count;
	int[] array;
	int pos;
	int len;

	public GetCounts(int[] array) {
		this.array = array;
		this.count = 0;
		this.pos = 0;
		this.len = array.length;
	}

	public int getNext() {

		if (pos < len - 1) {
			
		    int temp  = array[pos];
			int num = array[pos + 1];
			if(count == temp){
				pos = pos+2;
				count = 0;
				return getNext();
			}
			
			count++;
			return num;
		}
		return -1;

	}

	public static void main(String[] args) {

		int[] array = { 2, 7, 3, 1, 0, 2, 7, 3, 0, 1, 2, 5, 90 };
		GetCounts c = new GetCounts(array);

		int i = 0;
		while (i < 15) {
			System.out.println(c.getNext());
			i++;
		}

	}

}
