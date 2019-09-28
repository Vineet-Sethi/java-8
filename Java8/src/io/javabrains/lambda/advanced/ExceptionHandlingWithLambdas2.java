package io.javabrains.lambda.advanced;

import java.util.function.BiConsumer;

public class ExceptionHandlingWithLambdas2 {
	
	public static void main(String[] args) {
		int[] someNumbers = {1, 2, 3, 4};
		int key = 2;
		
		/*
		 Lambdas give us the flexibility to change behavior ie. tomorrow instead of addition we can pass on a divide operation like
		  		process(someNumbers, key, (v, k) -> System.out.println(v / k));
		  This means I pass in the numbers, I pass in the key and I also pass the behavior to the method telling it what to do with those
		  numbers and the key. Hence the same method now exhibits multiple behaviors.
		*/
		process(someNumbers, key, (v, k) -> System.out.println(v + k));
		process(someNumbers, key, (v, k) -> System.out.println(v - k));
		process(someNumbers, key, (v, k) -> System.out.println(v * k));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for(int i : someNumbers) 
		{
			consumer.accept(i, key);
		}
		System.out.println();
	}
}
