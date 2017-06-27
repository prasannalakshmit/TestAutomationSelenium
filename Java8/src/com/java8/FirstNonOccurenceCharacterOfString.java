package com.java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FirstNonOccurenceCharacterOfString {

	public static void main(String[] args) {
		System.out.println(findFirstNonRepChar("teeter"));
	}
	
	public static char findFirstNonRepChar(String string) {
		  Map<Character, AtomicInteger> characters = new LinkedHashMap<>(); // preserves order of insertion.
		  for (int i = 0; i < string.length(); i++) {
		    char c = string.charAt(i);
		    System.out.println("I value is : "+i);
		    AtomicInteger n = characters.get(c);
		    System.out.println("Value of C :"+c);
		    if (n == null) {
		      n = new AtomicInteger(0);
		      characters.put(c, n);
		    }
		    n.incrementAndGet();
		  }
		  for (Map.Entry<Character, AtomicInteger> entry: characters.entrySet()) {
		    if (entry.getValue().get() == 1) {
		      return entry.getKey();
		    }
		  }
		  throw new RuntimeException("No unrepeated character");
		}
}