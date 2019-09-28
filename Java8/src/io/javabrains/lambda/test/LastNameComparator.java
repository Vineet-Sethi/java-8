package io.javabrains.lambda.test;

import java.util.Comparator;

import io.javabrains.lambda.exercise.Person;

public class LastNameComparator implements Comparator<Person> 
{
	@Override
	public int compare(Person o1, Person o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}

}
