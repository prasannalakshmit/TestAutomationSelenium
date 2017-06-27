package com.java8.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSumOfElemetsFromArray {
	public static void main(String... args){
	List<Integer> numbers = new ArrayList<Integer>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    //print the sum in here 
    System.out.println(sumListRecursive(numbers));

	}
	public static int sumListRecursive(List<Integer> num){
		if (num.isEmpty()){
			return 0;
		}
		else{
			return num.get(0)+ sumListRecursive(num.subList(1, num.size()));
		}
		
	}
}
