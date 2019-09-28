package io.javabrains.lambda.advanced;

import java.util.function.BiConsumer;

public class ExceptionHandlingWithLambdas3 {
	
	public static void main(String[] args) {
		int[] someNumbers = {1, 2, 3, 4};
		int key = 0;
		
		/*
		  Passing a zero key would result in a "/ by zero" exception. We can handle this exception either here or within the process. Both
		  approaches have their down-sides.
		  
		  Handling the exception in the lambda seems right initially as its inside the lambda where we code the operation and we know what 
		  exception will be thrown and can write the exact catch block for it. However the try-catch handling syntax is such that the code 
		  looks messed up and not as crisp and elegant as a single line lambda earlier.
		*/
		process(someNumbers, key, (v, k) -> System.out.println(v / k));
		
		/*
		    process(someNumbers, key, (v, k) -> {
		    	try
		    	{
		    		System.out.println(v / k);
		    	}
		    	catch(ArithmeticException e) 
		    	{
					System.out.println("An Arithmetic Exception occurred");
			    }
		    });
		 */
	}

	/*
	 	Handling the exception within the process method doesn't seem right because the method isn't really aware of what operation the consumer
	    will be carrying out eventually. The operation might not be a divide operation at all as changing lambda expression can change the type 
	    of exception that might be raised. For eg for some other operation we might get a null pointer exception. So that doesn't mean that we 
	 	will write catch blocks for every possible exception that might ever occur in the process method. Doing this way would result in a long
	 	list of catch blocks in the method and it doesn't feel right at all. 
	 */
	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		
		/*for(int i : someNumbers) 
		{
			try{
				consumer.accept(i, key);
			}
			catch(ArithmeticException e) 
			{
				System.out.println("An Arithmetic Exception occured");
			}
		}*/
		
		for(int i : someNumbers) 
		{
			consumer.accept(i, key);
		}
	}
}
