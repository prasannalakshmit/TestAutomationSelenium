package com.java8.constructorchain;

public class ConstructorChainTest extends ChildB{
	
	ConstructorChainTest(){
		super("");
	}
	ConstructorChainTest(String msg){
		System.out.println("Single Argument constructor - ConstructorChainTest");
	}

	public static void main(String[] args) {
		//ConstructorChainTest constructorChainTest=new ConstructorChainTest("Must call ChildB Constructor.");
		ConstructorChainTest constructorChainTest=new ConstructorChainTest();
		//System.out.println("Constructor chaining executed");
	}

}
