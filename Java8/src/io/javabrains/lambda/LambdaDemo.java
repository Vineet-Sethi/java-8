package io.javabrains.lambda;

public class LambdaDemo {
	
	public static void main(String[] args) {
		lambdaDemo();
	}

	/*
	  	The lambda functions looks like as if it is implementing another version of Greeting class just like the GreetingConcreteImplementor due to 
	  	the way we are using the lambda function as myLambdaFunction.perform(); Since we do not have a name for the lambda's version of Greeting 
	  	implementation it looks even more similar to an anonymous innerclass implementation of Greeting. But these are not the same. The lambda's 
	  	can be viewed as a shortcut to code inner classes but these two are different things.
	*/
	private static void lambdaDemo() {
		
		GreetingInterface concreteGreeter = new GreetingConcreteImplementor();
		concreteGreeter.perform();

		GreetingInterface innerClassGreeting = new GreetingInterface() {

			@Override
			public void perform() {
				System.out.println("Hello InnerClass World!");
			}
		};
		innerClassGreeting.perform();
		
		GreetingInterface myLambdaFunction = () -> System.out.println("Hello Lambda World");
		myLambdaFunction.perform();
	}
}
