package io.javabrains.lambda.advanced;

import java.util.function.BiConsumer;

public class ExceptionHandlingWithLambdasSolution {
	
	public static void main(String[] args) 
	{
		int[] someNumbers = {1, 2, 3, 4};
		int key = 0;
		
		//process(someNumbers, key, passThroughLambdaWrapper((v, k) -> System.out.println(v - k)));
		//process(someNumbers, key, changeLambdaWrapper((v, k) -> System.out.println(v - k)));
		
		//Use the try-catch code adding lambdaWrapper method when needing a divide operation.		
		process(someNumbers, key, lambdaWrapper((v, k) -> System.out.println(v / k)));
	}
	
	/*
	    A pass through 
		private static BiConsumer<Integer, Integer> lambdaWrapper(BiConsumer<Integer, Integer> consumer)
		{
			return consumer;
		}
	
	    An operation changing wrapper - you pass in (v / k) and it returns (v + k); 
		private static BiConsumer<Integer, Integer> lambdaWrapper(BiConsumer<Integer, Integer> consumer)
		{
			return (v, k) -> System.out.println(v + k);
		}
	*/
	
	/*
		Exception Handling code adding wrapper
	*/
	private static BiConsumer<Integer, Integer> lambdaWrapper(BiConsumer<Integer, Integer> consumer)
	{
		System.out.println("lambdaWrapper called");
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			}
			catch(ArithmeticException e) 
	    	{
				System.out.println("An Arithmetic Exception occured");
		    }
	    };
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) 
	{
		System.out.println("process method called");
		for(int i : someNumbers) 
		{
			consumer.accept(i, key);
		}
	}
	
}
