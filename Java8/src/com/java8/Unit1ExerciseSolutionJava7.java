package com.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7 {

	public static void main(String[] args) {
		 List<Person> people = Arrays.asList(
		new Person("Prasanna","Lakshmi",23),
		new Person("Lakshmi","Prasanna",26),
		new Person("Prasanna","Lakshmi",16),
		new Person("Prasanna","Lakshmi",20)
		);
		 
		 //step 1: sort list by last name
		 Collections.sort(people, new Comparator<Person>(){

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
			 
		 });


	}

}
