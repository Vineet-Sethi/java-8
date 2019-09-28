package io.javabrains.lambda.advanced;

/*
    The value b here needs to be effectively final if its used in the lambda expression. The int b is a closure here & the compiler would
    complain if you change its value within the expression or after the runProcess method has been called.
    
 */
public class Closures {
	public static void main(String[] args){
		
		int a = 10;
		int b = 20; 
		
		/*
		   runProcess(a, new Process(){
				@Override
				public void execute(int i) 
				{
					System.out.println(i + b);
				}
			});
		*/
		
		runProcess(a, i -> System.out.println(i + b));
		
	}
	
	public static void runProcess(int i, Process p) {
		p.execute(i);
	}
}

interface Process {
	void execute(int i);
}
