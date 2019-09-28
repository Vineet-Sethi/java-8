package io.javabrains.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution5LambdaCombineMethods 
{
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 60),
					new Person("Lewis", "Caroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Mathew", "Arnold", 39)
				);
		
		Collections.sort(people, (Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName()));
		
		printConditionally(people, p -> true);
		
		System.out.println();
		
		Condition condition1 = (p) -> p.getLastName().startsWith("C");
		Condition condition2 = p -> p.getFirstName().startsWith("C");
		
		printConditionally(people, condition1);
		System.out.println();
		
		printConditionally(people, condition2);
		System.out.println();
		
		printConditionally(people, p -> p.getAge() < 50);
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

