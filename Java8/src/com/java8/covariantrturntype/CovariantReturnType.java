package com.java8.covariantrturntype;

class AA{
AA get(){return this;}
}

class CovariantReturnType extends AA{
	CovariantReturnType get(){return this;}
void message(){System.out.println("welcome to covariant return type");}

public static void main(String args[]){
new CovariantReturnType().get().message();
}
}
