package com.example.stack;

public class MyStack<T> {

	Node<T> top;
	
	private void push(T data){
		if(top == null){
			top = new Node(data);
		}else{
			Node node = new Node(data);
			node.next = top;
			top = node;
		}
	}
	
	private void display(){
		
		while(top != null){
			System.out.println(top.data);
			top = top.next;
		}
	}
	
	
	private void pop(){
		if(top == null)
			return ;
		else{
			top = top.next;
		}
	}                                                                                             

	public static void main(String[] args) {

		MyStack<String> stack = new MyStack<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.display();
		
		
		stack.sort();
	}

	private void sort() {
		// TODO Auto-generated method stub
		
	}

}
