package io.javabrains.lambda.advanced;

/*
   With a OO background we are accustomed to passing arguments in a method and then impl some behaviour with those arguments. Next if we need
   some different behaviour for the same arguments, for eg earlier it was addition of 2 integers and now its substraction, so we will add another 
   method probably with a different name in the same class. Now with lambdas we insist on coding behaviours via lambda expressions(which are
   essentially functional interface implementations) and passing them to the method. This way with different lambdas we pass in just the behaviour 
   and the method just executes them. This way the same method can exhibit multiple behaviours! 
*/
public class ExceptionHandlingWithLambdas1 
{
	public static void main(String[] args) 
	{
		int[] someNumbers = {1, 2, 3, 4};
		int key = 2;
		
		process(someNumbers, key);
	}

	/* This method will always add the key to the array of someNumbers. What if we need a process that will divide elements of the someNumbers
	   array with the provided key. Shall we code another process method or use lambdas and pass on different behaviors to the same method.
	*/
	private static void process(int[] someNumbers, int key) 
	{
		for(int i : someNumbers) 
		{
			System.out.println(i + key);
		}
	}
}
