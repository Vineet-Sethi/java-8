package io.javabrains.lambda.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.javabrains.lambda.exercise.Person;

public class PredicateConsumer {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 60),
					new Person("Lewis", "Caroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Mathew", "Arnold", 39)
				);
		
		/*
		   Here we have a lambda expression that takes in an argument and calls a method which also has the same argument passed in hence this
		   is also a candidate to be replaced with a method reference. 
		   
		   Now the question is how does it know about the argument when you explicitly removed it. 
		   The answer is that this method reference will be taking the place of a consumer which always takes in some input argument. Hence if a
		   method reference takes the place of a consumer the compiler knows that something needs to be passed in to it. So wherever we have the
		   structure (arg) -> method(arg) or () -> method() we can replace it with a method reference.
		   
		   In the previous example the method reference was not taking any arguments and so the compiler knew that it was a regular method call 
		   without any args. Here it is a Consumer<Person> and hence it will take an argument of type Person p.   
		*/
		printConditionally(people, p -> true, p -> System.out.println(p));
		printConditionally(people, p -> true, System.out::println);
	}

	private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) 
	{
		for(Person p : people) 
		{
			if(predicate.test(p))
				consumer.accept(p);
		}	
	}
}

interface Condition{
	boolean test(Person p);
}