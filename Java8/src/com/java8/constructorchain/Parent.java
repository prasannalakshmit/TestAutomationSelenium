package com.java8.constructorchain;

public class Parent {
	Parent(){
		System.out.println("In Parent Default Constructor");
	}
	Parent(String msg){
		System.out.println("In Parent Single Argument constructor.");
	}

}
