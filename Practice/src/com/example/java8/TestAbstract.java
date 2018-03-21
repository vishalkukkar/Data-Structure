package com.example.java8;

public abstract class TestAbstract {
	
	public abstract int get(int a,int b);
	
	public int get(int a){
		return 1;
	}
	
	public static void main(String[] args) {
		
		TestAbstract t = new TestAbstract() {
			
			@Override
			public int get(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
		};

	}

}
