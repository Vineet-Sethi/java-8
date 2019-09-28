package io.javabrains.lambda.advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import io.javabrains.lambda.exercise.Person;

public class PredicateExample 
{
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 60),
					new Person("Lewis", "Caroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Mathew", "Arnold", 39)
				);
		
		printConditionally(people, p -> true);
		printConditionally(people, p -> p.getLastName().startsWith("C"));
		printConditionally(people, p -> p.getFirstName().startsWith("C"));
		printConditionally(people, p -> p.getAge() < 50);
	}

	/*
	  Creating a functional interface with an abstract method declared in it just for defining the type of the lambda seems like an overhead. 
	  Since the name of the interface as well the abstract method inside it doesn't matter to the lambda expression and all it is trying to 
	  match is the signature the java.util.function package defines several out of the box interfaces ready for the developers to use.
	  
	  In our case we will use the Predicate interface. The predicate has a test method that takes in an object and returns a boolean. Hence 
	  it exactly matches our scenario. The predicate accepts a generic type so we can customize it for our person object. With this we don't
	  need the condition interface anymore. 
	*/
	private static void printConditionally(List<Person> people, Predicate<Person> predicate) 
	{
		for(Person p : people) 
		{
			if(predicate.test(p))
				System.out.println(p);
		}
		System.out.println();
	}
}

