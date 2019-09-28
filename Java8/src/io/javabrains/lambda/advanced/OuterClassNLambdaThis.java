package io.javabrains.lambda.advanced;

public class OuterClassNLambdaThis {
	
	public void doProcess(int i, Process p) {
		System.out.println("doProcess " + this);  
		p.execute(i);
	}
	
	public void processIt() {
		System.out.println("processIt " + this);  
		
		doProcess(10, i -> {
				System.out.println(i);
				System.out.println(this);    // works
			}
		);
	}
	
	public static void main(String[] args) {
		
		OuterClassNLambdaThis lambdasThisReferenceExample = new OuterClassNLambdaThis();
		 
		//System.out.println(this); - 'this' Does not work in static contexts
		
		/*
		   Lambdas treat the this reference in a different way as compared to anonymous inner classes. In an AIC overrides the this 
		   reference points to the instance which calls the overridden instance method the lambda expression. In lambdas the this reference continues
		   to be what it was outside of the lambda. So since within the main method as the this does not work as main is a static context 
		   the this also doesn't work inside the lambda as well.
		   And if we write an instance method and use this reference inside the lambda itself the this will now refer to whatever object 
		   instance called the instance method. The catch here is that the 'this' inside a lambda works depending on "where the lambda 
		   expression is written" or where the lambda function body is defined.  
		*/
		/*lambdasThisReferenceExample.doProcess(10, i -> {
				//System.out.println(i);
				//System.out.println(this);    //Will not work here as its a static context
			}
		);*/
		
		lambdasThisReferenceExample.processIt();
	}
}
