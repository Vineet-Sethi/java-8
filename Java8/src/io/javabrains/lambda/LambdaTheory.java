/*
	1. Java is inherently an OOP language and is actually quite successful. However newer programming paradigms such as functional programming have
	   evolved off late. These paradigms allow us to write clear, concise and hence more maintainable code. However functional programming is not
	   letting us do something new or something that we could have not done in Java, it is only helping us do it in a better way. So to catch up with
	   these Java 8 introduced Lambdas which are a new programming construct that enable functional programming in Java. They also enable support for 
	   parallel processing.  
	
	In OOPs everything is an object and all code blocks are associated inside classes or within methods inside classes. So in java we cannot have a 
	code block in isolation on its own. We have to make it a part of a class. So the question arises what if we just needed a function. This is the 
	first point. 
	
	2. Next consider the below greet method
	
				    public void greet() {
						System.out.println("Hello World!");
					}
	    
	    This greet method would always print Hello World to the console. What if we needed it to do different things as per some input parameter. We
	    can do this in Java by using switch inside the greet implementation and then it would know what to do as per the passed parameter. However this 
	    is not an elegant way of doing it. What if we could just pass in a behaviour and let the greet method just execute that behaviour. This can be
	    done in Java by passing implementations of an interface as an argument to the greet method.	   
	     				
	     				public void greet(Greeting greeting) {
							   greeting.perform();
						}
	    
	    The second greet method accepts a behaviour and just executes it. However we are not actually passing in a behaviour. We are passing a thing 
	    that contains a behaviour. This means that somewhere we would have a Greeting interface and we would then write a concrete implementation(s)
	    of it and then this interface implementation class that contains the behaviour is passed on to the greet method. It would be better if we 
	    could just pass a method straightaway somewhat like below and execute it directly
	    	
	    	public void greet(action) {
				action();
			}
		
		Lambdas help us to achieve just that. To do this we must be able to assign a block of code to a variable which gives us the next point.
	
	3. In java we can assign a value to a variable like int i  = 10 or double pi = 3.14. We can as well assign an object instance to a variable. Like
	   Person p = new Person().
	  
	   Lambdas emphasize on assigning a function itself to a variable like
	    	
	    	aBlockofCode = {
	    			...
	    			...
	    	}
        
       So aBlockofCode = public void perform() {
							System.out.println("Hello World");
						 }
	   
	   And what if we could pass this variable that refers to the block of code. We need to carve out a Lambda function out of this code first.
	   
	   In lambdas we dont need 
	   		the access modifier as it is more class related
	   		the method name as we have the variable name. 
	   		We also dont need the return type as the compiler can figure it out. So we practically remove everything on the left of ()
	   		
	   		Hence the lambda expression syntax is
	    	
	    	aBlockofCode = () -> {                                   // -> is added
							System.out.println("Hello World");
						 }
						 
			OR just aBlockofCode = () -> System.out.println("Hello World");   //If its a single line function no {} needed
			                                                                  //So what's left is a lambda function but aBlockofCode still lacks the type
			
			Eg: doubleNumberFunction = (int a) -> a * 2;    //If its a single line return statement is not needed and is actually invalid if u use it.
			 	addFunction = (int a, int b) -> a + b;
			 	stringLengthCountFunction = (String s) -> s.length();
			 	safeDivideFunction = (int a , int b) -> {
			 		if(b == 0) return 0;
			 		return a / b;
			 	}
			 	
		 To actually use the lambda expression in a java class you need to define the type of the lambda variable. This type is defined by backing the
		 lambda with an interface that contains a method whose signature matches the lambda expression signature. Hence to write a lambda like
		 
		  	  MyLambda myLambdaFunction = () -> System.out.println("Hello World");
		  		 
		 We need to create an interface as below and use its type as the type for the lambda expression.
					 
					 interface MyLambda{
					 	void foo();
					 }
		 
		 Note: The interface must have only 1 method otherwise compiler gives an error.			
		 The lambda behaves like an instance of the interface it is trying to match. It is pretty much indistinguishable from any other implementation
		 of the interface like a concrete or inner class implementation when passed as an argument to a method that accepts the interface type.
		  
		 Functional Interface: These are interfaces with only 1 abstract method. As opposed to java 7 where all methods were abstract, from Java 8 you 
		 can add default implementations for methods inside a class. Hence by definition of functional interfaces an interface with several implemented
		 methods and 1 abstract method is still a functional interface. 
		 
		 To prevent/notify other developers from breaking your functional interfaces we need to put a @FunctionalInterface annotation. This is an 
		 optional annotation in the sense that its not required from lambdas to work but it is a good practice to be followed. 
		 
		 The reason why Java language designers choose the interface type as the type for lambdas versus creating a new function type is backward 
		 compatibility. Consider that if a new function type had been created for lambdas then all those libraries would have had to be rewritten to 
		 accept this new function type by probably overloading methods that would accept this new function type. Hence by using interfaces all those 
		 library methods which were accepting interface references can now accept lambda expressions as well. Of course the restriction is still there
		 that those interfaces must have only one method however the backward compatibility is still a huge advantage. 
		 Eg Runnable interface & Threads.
		 	The thread class accepts a runnable when we instantiate new threads. Since Runnable has only 1 abstract method run() it is a good
		 	candidate for being  a functional interface and hence lambda implementations for it can be written.
		 	
		 So if lambda's type was not an interface type and its own specialized one then we probably had to write another constructor for Thread
		 class that would accept this new type. 
		 
		 *****
		 	 So basically whenever we write a lambda it feels like that we are writing a behaviour/functionality in isolation however there has to be
			 an interface somewhere which has a method whose signature matches with that of the lambda. The interface must conform to the specs of a 
			 functional interface written by programmer himself or functional interfaces provided within java. The lambda itself is an implementation
			 of this interface. This means Interface i = LAMDA_FUNCTION is an implementation of the interface then and there itself similar to an AIC.
			 So i.interfaceMethod() would essesntially trigger the lambda.
			 Hence writing multiple lambdas mean multiple implementations of that interface each having its own behaviour and by not having to write
			 interface code each time as several functional interfaces are already present in the java package, it feels like creating behaviours on
			 the fly.
		*****
*/