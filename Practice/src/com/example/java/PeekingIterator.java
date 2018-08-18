package com.example.java;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {

	private Iterator<Integer> iterator = null;
	Integer peekElement = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;

		if (this.iterator.hasNext())
			peekElement = this.iterator.next();
		else
			peekElement = null;

	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return peekElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {

		Integer temp = peekElement;
		
		if(iterator.hasNext()){
			peekElement = iterator.next();
		}else{
			peekElement = null;
		}
		
		return temp;

	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext() && peekElement != null;

	}

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3);
		Iterator<Integer> iterator = list.iterator();
		PeekingIterator p = new PeekingIterator(iterator);
		
		System.out.println(p.next());
		System.out.println(p.peek());
		System.out.println(p.next());
		System.out.println(p.next());
		System.out.println(p.hasNext());
		
		

	}
}