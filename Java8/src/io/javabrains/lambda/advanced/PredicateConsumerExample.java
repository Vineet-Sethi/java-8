package io.javabrains.lambda.advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.javabrains.lambda.exercise.Person;

public class PredicateConsumerExample 
{
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 60),
					new Person("Lewis", "Caroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Mathew", "Arnold", 39)
				);
		
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		
		printConditionally(people, p -> true, p -> System.out.println(p));
		
		System.out.println();
		
		printConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));
		System.out.println();
		
		printConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));
	}

	/*
	 The method below prints to the console everytime. What if we could pass in a behaviour so that it does not print everytime but it just
	 executes the behaviour passed on to it. If we look closely the System.out.println(p) the behaviour is that we would need a method that
	 accepts an object and returns nothing. The printing requirement that we have can be defined in the lambda expression that we will write.s
	 In the java.util.function package we have a Consumer<T> which has an accept(T t) method. This fits our requirement. Hence we can use it.
	 
	 So now while calling we pass in the behaviour and in fact we can change the behaviour as we did in the case of last call where in we
	 just print the first name.
	  
	*/
	private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) 
	{
		for(Person p : people) 
		{
			if(predicate.test(p))
				consumer.accept(p);
		}
	}
}

