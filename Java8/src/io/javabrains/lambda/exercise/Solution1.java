package io.javabrains.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Solution1 {
	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 60),
					new Person("Lewis", "Caroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Mathew", "Arnold", 39)
				);
		
		Collections.sort(people, new LastNameSorter());
		
		printAll(people);
		printAllBeginningWithC(people);
	}

	private static void printAllBeginningWithC(List<Person> people) {
		Iterator<Person> itr = people.iterator();
		while(itr.hasNext()) {
			Person p = itr.next();
			
			if(p.getLastName().substring(0, 1).equals("C"))
				System.out.println(p);
		}
	}
	
	public static void printAll(List<Person> people) 
	{
		for(Person p : people) 
		{
			System.out.println(p);
		}
			
	}
}
