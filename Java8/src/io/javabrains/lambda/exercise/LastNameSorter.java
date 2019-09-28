package io.javabrains.lambda.exercise;

import java.util.Comparator;

public class LastNameSorter implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		// TODO Auto-generated method stub
		return person1.getLastName().compareTo(person2.getLastName());
	}

}
