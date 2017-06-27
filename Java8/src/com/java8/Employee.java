package com.java8;

import java.util.Comparator;

public class Employee {
	
	String name;
    String id;
   
    public Employee() {}
   
    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }
   
   
    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id  + '}';
    }
 
    //Inner class
    class ComparatorName  implements Comparator<Employee>{
       @Override
        public int compare(Employee obj1, Employee obj2) {
           //sort Employee on basis of name(ascending order)
           return obj1.name.compareTo(obj2.name);
        }
    }
   
 
    //static Inner class
    static class ComparatorId  implements Comparator<Employee>{
       @Override
        public int compare(Employee obj1, Employee obj2) {
           //sort Employee on basis of id(ascending order)
           return obj1.id.compareTo(obj2.id);
        }
    }

}
