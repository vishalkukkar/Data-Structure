package com.example.arrayy;

public class Calculator {

	@FunctionalInterface
	interface MathOperation {
		int operation(int number1, int number2);
	}

	public int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	private void addition(int a,int b) {
		MathOperation additionOp = (number1, number2) -> a + b;
		System.out.println("Addtion " + operate(a, b, additionOp));
	}

	private void subtraction() {
		MathOperation subtractionOp = (number1, number2) -> number1 - number2;
		System.out.println("50 - 10 = " + operate(50, 10, subtractionOp));
	}

	private void multiplication() {
		MathOperation multiplicationOp = (number1, number2) -> number1 * number2;
		System.out.println("50 * 10 = " + operate(50, 10, multiplicationOp));
	}

	private void division() {
		MathOperation divisionOp = (number1, number2) -> number1 / number2;
		System.out.println("50 / 10 = " + operate(50, 10, divisionOp));
	}

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		Calculator calculator = new Calculator();
		calculator.addition(1,2);
		calculator.subtraction();
		calculator.multiplication();
		calculator.division();
	}
}