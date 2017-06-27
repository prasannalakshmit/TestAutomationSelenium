package com.java8.constructorchain;

public class ChildB extends ChildA{
	ChildB(){
		super("");
		//this("");
		//System.out.println("In ChildB");
	}
	ChildB(String msg){
		System.out.println("In ChildB single Arguement constructor.");
		
	}

}
