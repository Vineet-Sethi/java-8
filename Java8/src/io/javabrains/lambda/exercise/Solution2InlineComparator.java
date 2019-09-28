package io.javabrains.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2InlineComparator 
{
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 60),
					new Person("Lewis", "Caroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Mathew", "Arnold", 39)
				);
		
		//Inline comparator instead of a separate class
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		printAll(people);
		System.out.println();
		
		printAllBeginningWithC(people);
	}

	public static void printAll(List<Person> people) 
	{
		for(Person p : people) 
		{
			System.out.println(p);
		}
	}
	
	//Doing this way is really inflexible as tomorrow of we need to print all "last names" beginning with D we need another method.
	//You can argue that why not pass in a char argument too in the printAllBeginningWith<X> method to print names starting with the specified
	//letter. This seems right until we get a requirement to print all people whose age is say less than 50 and we then need another method
	//with an int argument
	private static void printAllBeginningWithC(List<Person> people) 
	{
		for(Person p : people) 
		{
			//if(p.getLastName().substring(0, 1).equals("C"))
			if(p.getLastName().startsWith("C"))
				System.out.println(p);
		}
	}
}
