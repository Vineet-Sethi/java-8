package io.javabrains.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution3ConditionObject 
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
		
		printAll(people);
		System.out.println();
		
		Condition lastNameCondition = new Condition() {

			@Override
			public boolean test(Person p) {
				return(p.getLastName().startsWith("C"));
			}
			
		};
		
		
		
		Condition firstNameCondition = new Condition() {

			@Override
			public boolean test(Person p) {
				return(p.getFirstName().startsWith("C"));
			}
			
		};
		
		Condition ageCondition = new Condition() {

			@Override
			public boolean test(Person p) {
				return (p.getAge() < 50);
			}
			
		};
		
		printConditionally(people, lastNameCondition);
		
		printConditionally(people, firstNameCondition);
		
		printConditionally(people, ageCondition);
	}

	public static void printAll(List<Person> people) 
	{
		for(Person p : people) 
		{
			System.out.println(p);
		}
	}
	
	private static void printConditionally(List<Person> people, Condition condition) 
	{
		for(Person p : people) 
		{
			if(condition.test(p))
				System.out.println(p);
		}
	}
}

interface Condition{
	boolean test(Person p);
}
