package io.javabrains.lambda;

/*
   The Thread constructor can accept 
     1. A concrete class that implements Runnable
     2. An anonymous inner class implementation of Runnable
     3. A lambda expression(that matches the run method's signature)
     
   All this is possible as the Runnable interface is a Functional Interface.
 */

public class BackwardCompatibility {
	
	public static void main(String[] args) {
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Printed inside Runnable");
			}
		});
		
		myThread.start();
		
		Thread myThread2  = new Thread(() -> System.out.println("Printed inside Lambda Runnable"));
		myThread2.start();
	}
}
