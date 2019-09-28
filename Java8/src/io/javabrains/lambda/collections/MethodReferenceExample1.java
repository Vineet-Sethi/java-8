package io.javabrains.lambda.collections;

public class MethodReferenceExample1 {
	public static void main(String[] args) {
		
		/*
			 Thread t = new Thread(new Runnable() {
	
				@Override
				public void run() {
					printMessage();
				}
				
			 });
			 
			 Thread t = new Thread(() -> System.out.println("Hello"));
		*/
		
		/*
		    When you have a lambda expression that takes in no arguments and calls a method which also has no argument then you can replace your 
		    lambda with a method reference.
		    		OR
		    When you have a lambda expression that takes in some arguments and calls a method which also has the same arguments passed then you 
		    can replace your lambda with a method reference.
		    
		    So if at all you are doing is executing a method in your lambda expression you can use a method reference for it.
		*/
		Thread t1 = new Thread(() -> printMessage());
		t1.start();
		
		Thread t2 = new Thread(MethodReferenceExample1::printMessage);  //MethodReferenceExample1::printMessage === () -> printMessage() 
		t2.start();
	}

	public static int printMessage() {
		System.out.println("Hello");
		return 5;
	}
}
