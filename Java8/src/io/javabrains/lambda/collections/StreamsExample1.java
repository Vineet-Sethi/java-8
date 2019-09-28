package io.javabrains.lambda.collections;

import java.util.Arrays;
import java.util.List;

import io.javabrains.lambda.exercise.Person;

/*
  Assembly Line Analogy -> Perform multiple operations on each list element in a single iteration rather than performing a single operation on the
  elements per iteration. The idea is to reduce the number of iterations to a minimum(1). 
 */
public class StreamsExample1 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Caroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Mathew", "Arnold", 39)
			);
		
		/*
		   Executing multiple operations on the people stream in a single iteration. The result is an accumulative effect of all operations on the
		   elements at the end of the iteration. 
		*/
		people.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.forEach(p -> System.out.println(p.getFirstName()));
		
		/*
		   A stream is basically a view of the collection. Its another way of looking at the collection and just having a stream initialized doesn't 
		   mean that the iteration has started. Hence Stream<Person> stream =  people.stream() is just a view.
		   A stream is comprised of 3 parts
		      1. Source: It is the collection providing elements to the stream. A stream always has a source
		      2. Intermediate operation: It is the operation or operations that you want to perform on the stream. For eg  
		      		people.stream() .filter(p -> p.getLastName().startsWith("C")) defines an intermediate operation. However this means that you
		      	 have just set an operation on the stream and you have not yet started the stream. Its just like positioning the mechanic on the
		      	 assembly line but not yet starting the assembly line. The stream doesn't start until you add a terminal operation on it which is 
		      	 the third part a stream comprises of.
		      3. Terminal Operation: Is what causes the stream to act upon the operations set on it and set the things in motion.
		*/
		long count = people.stream()
		.filter(p -> p.getLastName().startsWith("D"))
		.count();
		
		System.out.println(count);
		
		/*
		   people.parallelStream()  //This can potentially split the collection into multiple streams if it feels that multiple cores can be used to
		   make it process faster. This is how functional programming cause parallelism.
		 */
	}
}
