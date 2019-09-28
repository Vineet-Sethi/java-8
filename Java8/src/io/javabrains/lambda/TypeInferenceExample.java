package io.javabrains.lambda;

public class TypeInferenceExample {
	
	public static void main(String[] args) {
		
		//StringLengthLambda myLambda = (String s) -> s.length();
		//StringLengthLambda myLambda = (s) -> s.length();   //You can take off the return type of all arguments as lambdas are backed by interfaces
		                                                     //and as such complete signature information is present there.
		//StringLengthLambda myLambda = s -> s.length();     //If there is only one argument you can remove the parentheses too.
		                                                     //In a nutshell this is the function body now that will be called at some point in time
															 //To the left of the -> we have the arguments and to the right is the function implementation
		
		LambdasInterface MY_LAMBDA = s -> s.length(); 
		int len = MY_LAMBDA.lambdasMethod("Hello World");
		System.out.println(len);
		
		MY_LAMBDA = s -> s.hashCode(); 
		int hCode = MY_LAMBDA.lambdasMethod("Java8");
		System.out.println(hCode);
		
		int charCode = charCodeAt0Index(s -> s.codePointAt(0));
		System.out.println(charCode);
 	}
	
	public static int charCodeAt0Index(LambdasInterface MY_LAMBDA) 
	{
		return MY_LAMBDA.lambdasMethod("Hello Lambda");
	}
}

interface LambdasInterface{
	int lambdasMethod(String s);
}
