package io.javabrains.lambda.advanced;

public class OuterNInnerClassThis {
	
	public void doProcess(int i, Process p) 
	{
		System.out.println(this);
		p.execute(i);
	}
	
	public static void main(String[] args) 
	{
		//System.out.println(this); - 'this' Does not work in static contexts
		
		/*
		   The this reference always points to the currently executing object. Whenever we call an instance method of any class we do so by
		   calling objRef.methodName(). Hence within the instance method the this reference will point to objRef. Also we cant access 'this'
		   in a static context as static methods are called without having any object. Hence System.out.println(this) within main results in
		   an error message.
		   
		   In the Anonymous inner class approach the this reference works and is overridden to point to inner class object reference. Hence 
		   the code below works as the execute method is called by an instance of the AIC Process and the this points to the reference of 
		   this object.
		*/
		
		OuterNInnerClassThis ref = new OuterNInnerClassThis();
		ref.doProcess(10, new Process() {
											@Override
											public void execute(int i) 
											{
												System.out.println(this);
											}
											
											public String toString() 
											{
												return "This - Anonymous inner class";
											}
										});
	}
	
	public String toString() 
	{
		return "This - Outer Class";
	}
}
