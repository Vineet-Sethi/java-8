package io.javabrains.lambda.test;

public class Demo 
{
	public static void main(String[] args) 
	{
		Lambda lambdaImpl1 = s -> s.length();
		Lambda lambdaImpl2 = s -> s.hashCode();
		Lambda lambdaImpl3 = s -> s.codePointAt(0);
		
		int i1 = lambdaImpl1.foo("Deutschland");
		int i2 = lambdaImpl2.foo("Deutschland");
		int i3 = lambdaImpl3.foo("Deutschland");
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
	}
}

interface Lambda 
{
	int foo(String s);
}


