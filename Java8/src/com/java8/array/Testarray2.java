package com.java8.array;

public class Testarray2 {
	
	static void min(int arr[]){  
		int min=arr[0]; 
		System.out.println("initial value of min is "+min);
		for(int i=1;i<arr.length;i++)  
		 if(min>arr[i])  {
		  min=arr[i];
		System.out.println("Min IS inside if" +min);
		 }else{
			 min=arr[i];
		//System.out.println("MINUMUM IS" +min);  
		} 
		//min=arr[i];
		//System.out.println("mINIMUM IS:::: INSIDE FOR, OUTSIDE IF" +min);
	}	  
		public static void main(String args[]){  
		  
		int a[]={1,3,0,4,5};  
		min(a);//passing array to method  
		  
		}

}
