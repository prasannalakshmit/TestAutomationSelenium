package com.testframework.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UtilizeDictionaryObject {

	public UtilizeDictionaryObject(HashMap oDict){
		System.out.println("Inside constructor");
		List <String> excelValueRowList = null;
		Object header = oDict.keySet().toArray()[0];
		List<Object> valueForheader = (List<Object>) oDict.get(header);
		System.out.println("Value For header :"+valueForheader);
		   List <String> excelHeaderKeysList = new ArrayList<String>();
		   for (int i = 0; i < valueForheader.size(); i++){
			   System.out.println("Header Element : "+valueForheader.toArray()[i].toString());
			   excelHeaderKeysList.add(valueForheader.toArray()[i].toString());
		   }
		   Object valuesForRows = oDict.keySet().toArray()[1];
			List <Object> valueForRow = (List<Object>) oDict.get(valuesForRows);
			System.out.println("Value For Row : " +valueForRow);
			
			excelValueRowList = new ArrayList<String>();
			List <String> listOfExcelRows = new ArrayList<String>();
			for (int i = 0; i < valueForRow.size(); i++){
			System.out.println("Row Elements : "+valueForRow.toArray()[i].toString());
				excelValueRowList.add(valueForRow.toArray()[i].toString());
			}
			String firstElementOfHeader = excelHeaderKeysList.get(0);
			   String firstElementOfRow = excelValueRowList.get(0);
			   System.out.println("First Element of the header is :" +firstElementOfHeader);
			   System.out.println("First Element of the row is : "+excelValueRowList.get(0));
			   
			   if (firstElementOfRow.equalsIgnoreCase("yes")){
				   System.out.println("Proceed with Execution");
			   }
			   else if (!firstElementOfRow.equalsIgnoreCase("no")){
				   System.out.println("Dont Proceed with Execution");
			   }
		System.out.println("I am The New Class to Utilize the Dictionary Object");
	}
}
