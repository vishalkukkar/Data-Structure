package com.example.stack;

public class StackArray<E> {

	int size = 0;
	int capacity;
	E[] array = null;
	int top = -1;

	public StackArray(int capacity) {
		this.array = (E[]) new Object[capacity];
		this.capacity = capacity;
	}

	public Boolean push(E value) {

		if (this.size == this.capacity) {
			System.out.println("stack is full..!");
			return false;
		} else {
			this.size++;
			this.array[++top] = value;
			return true;
		}

	}

	public E pop() {

		if (size == 0)
			return null;
		else {
			this.array[top] = null;
			top--;
			size--;
		}
		return null;
	}

	public void display() {

		for (int i = 0; i < this.array.length; i++) {
			if (array[i] != null)
				System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {

		StackArray<String> a = new StackArray<String>(5);
		a.push("a");
		a.push("b");
		a.push("c");
		a.push("d");
		a.push("e");

		a.display();

		System.out.println("\n\n");
		a.pop();
		a.pop();
		a.display();

		a.push("e");
		a.push("f");
		System.out.println("\n\n");
		a.display();
	}

}
