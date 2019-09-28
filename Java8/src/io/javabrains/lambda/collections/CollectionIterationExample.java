package io.javabrains.lambda.collections;

import java.util.Arrays;
import java.util.List;

import io.javabrains.lambda.exercise.Person;

public class CollectionIterationExample {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Caroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Mathew", "Arnold", 39)
			);
		
		/*
		    Here in the below 2 traditional ways we r telling the order in which to execute the loops. These kinds of iterators are called external
		    iterators where-in we control the way the iteration should happen. Here we define the index, define how it should be incremented and
		    the end-point as well. In the second one we create the person object reference with each iteration and use it for printing. Hence we
		    are controlling/managing the iteration process.
		 */
		System.out.println("Using for loop");
		for(int i = 0; i < people.size(); i++){
			System.out.println(people.get(i));
		}
		
		System.out.println("Using for in loop");
		for(Person p: people){
			System.out.println(p);
		}
		
		/*
		   Java 8 introduces a new way of iteration where-in we are giving the control to the Java runtime. We just communicate our intent that we
		   want this collection to be iterated and it is really upto the java runtime as to how to go about iterating. And this way the runtime
		   is free to iterate the way it wants to like employing multi-threading optimizing it etc. This kind of iterator is internal iterator.
		*/
		System.out.println("Using lambda for each loop");
		people.forEach(p -> System.out.println(p));
		
		//As the above is a recognizable pattern for method reference we can further write it as below
		System.out.println("Using method reference syntax");
		people.forEach(System.out::println);
		
	}
}
