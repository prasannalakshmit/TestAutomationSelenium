package com.java8.stringformat;

public class FormatExample{  
public static void main(String args[]){  
/*String name="sonoo";  
String sf1=String.format("name is %s",name);  
String sf2=String.format("value is %f",32.33434);  
String sf3=String.format("value is %32.12f",32.33434);//returns 12 char fractional part filling with 0
int h=12,m=30,s=56;
int hour=((h>=0 && h<24)?h:0);
int minute=((m>=0 && m<60)?m:0);
int second=((s>=0 && s<60)?s:0);
Object[] data = {hour,minute,second};
String sf4=String.format("%d:%d:%d", data); 
  
System.out.println(sf1);  
System.out.println(sf2);  
System.out.println(sf3);
System.out.println(sf4);*/
	System.out.printf("%-12s%-12s%s\n","Column 1","Column 2","Column3");
	System.out.printf("%-12d%-12d%07d\n",15,12,5);

}}  