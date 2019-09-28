package io.javabrains.lambda.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.javabrains.lambda.exercise.Person;

public class Exercise 
{
	public static void main(String[] args) 
	{
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Caroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Mathew", "Arnold", 39));
		
		//Step1: Sort list by last name
		//Step2: Create a method that prints all elements in the list
		//Step3: Create a method that prints all people who have last name beginning with C
		
		//Collections.sort(people, new LastNameComparator());
		//people.forEach(System.out::println);
		//Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		//Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());
		//printList(people);
		
		//printList(people, p -> p.getLastName().startsWith("C"));
		//printList(people, p -> p.getFirstName().startsWith("C"));
		//printList(people, p -> p.getAge() > 50);
		printList(people, p -> true);
		
	}

	private static void printList(List<Person> people, Scenario s) 
	{
		for(Person p : people) 
		{
			if(s.check(p))
				System.out.println(p);
		}
	}
}

interface Scenario 
{
	boolean check(Person p);
}
