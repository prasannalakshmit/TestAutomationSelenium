package com.java8.constructorchain;

public class ChildA extends Parent{
	ChildA(){
		super("");
		//System.out.println("In ChildA");
	}
	ChildA(String msg){
		System.out.println("In ChildA Single Argument Constructor.");
	}

}
