package com.java8;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeCompare {

    String name;
    int sal;

    //Other implementations
    
    public static void main(String... args){
    	Employee emp1=new Employee("sam","4");
        Employee emp2=new Employee("amy","2");
        Employee emp3=new Employee("brad","1");

        ArrayList<Employee> list=new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
      
        System.out.println("list Before sorting : \n"+list);
 
        Collections.sort(list,new Employee().new ComparatorName());
        System.out.println("\nlist after sorting on basis of name(ascending order), "
                  + "using inner class : \n"+ list);
 
        Collections.sort(list,new Employee.ComparatorId());
        System.out.println("\nlist after sorting on basis of id(ascending order), "
                  + "using static inner class : \n"+list);
       
    }
    	
    }

    /*public int compareTo(Object o1) {

        Employee e = (Employee)o1;
        int iSalComaprison = Integer.compare(this.sal, e.sal);
        System.out.println("iSalComaprison "+iSalComaprison  );
        if (iSalComaprison == 0)//Salaries are equal use name as comparison criteria
        {
            //lhs name comparison with rhs name
            return name.compareTo(e.name);
        }
        //Now if salaries are not equal, return comparison of salries
        return iSalComaprison;

    }

}*/