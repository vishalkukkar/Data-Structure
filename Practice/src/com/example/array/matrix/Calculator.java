package com.example.array.matrix;

class Calculator {

	@FunctionalInterface
	interface MathOperation {
		int operation(int a, int b);
	}

	public int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	public void addition(int a, int b) {
		MathOperation additionOp = (number1, number2) -> a + b;
		System.out.println("Addtion " + operate(a, b, additionOp));
	}

	public void substraction(int a, int b) {
		MathOperation subStarctionOp = (number1, number2) -> a - b;
		System.out.println("substraction " + operate(a, b, subStarctionOp));
	}

	public void multiply(int a, int b) {
		MathOperation multiplyOp = (number1, number2) -> a * b;
		System.out.println("MultiplyOp " + operate(a, b, multiplyOp));
	}

	public void divide(int a, int b) {
		MathOperation divideOp = (number1, number2) -> a / b;
		System.out.println("DivideOp " + operate(a, b, divideOp));
	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();
		calc.addition(10, 20);
		calc.substraction(10, 20);
		calc.multiply(10 ,20);
		calc.divide(10,20);

	}

}