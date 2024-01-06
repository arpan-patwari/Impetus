package com.java.lamda;

public class Lamda {
	
	public static void main(String[] args) {
		System.out.println("Fucnntional tests");
		
		Display d = (a,b)->{
			System.out.println("The sum is "+a+b);
			return a + b;
		};
		d.toCalculation(1, 2);
		
		Display d2 = (a,b)->{
			System.out.println("The difference is "+(a-b));
			return a - b;
		};
		
		d2.toCalculation(1, 2);

		Display dx = (a, b) -> {
			return a + b;
		};
		
	}
}
