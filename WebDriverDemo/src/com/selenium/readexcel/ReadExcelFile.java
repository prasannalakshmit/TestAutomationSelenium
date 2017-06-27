package com.selenium.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		
		//Map<Integer, List<String>> excelDataMap = new HashMap<Integer, List<String>>();
		Map<Integer, List<String>> excelDataMap=new LinkedHashMap<Integer, List<String>>();
		//Create an object of ReadGuru99ExcelFile class

		ReadExcelFile objExcelFile = new ReadExcelFile();

	    //Prepare the path of excel file

	    String filePath = System.getProperty("user.dir")+"\\src\\";
	    System.out.println("user dir : "+System.getProperty("user.dir"));
	    System.out.println("File Name : "+filePath);
	    //Call read file method of the class to read data

	    //excelDataMap = objExcelFile.readExcel(filePath,"R8_Orange_TestData.xlsx","Sheet1");
	    excelDataMap = objExcelFile.readExcel(filePath,"GSD_CSC_TestData.xls","Login");
	    /*Iterator iterator = excelDataMap.keySet().iterator();
	    while(iterator.hasNext()){
	    	   Object key =  iterator.next();
			   System.out.println("key : "+key);
			   String valueRow= excelDataMap.get(key).toString();
			   System.out.println("Value Row:"+valueRow);
	    
	    }*/

	    }

	
	public Map<Integer, List<String>> readExcel(String filePath,String fileName,String sheetName) throws IOException{

		Map<Integer, List<String>> excelData = new LinkedHashMap<Integer,List<String>>();
		String cell = null;
		List<String> cellData = null;
		//Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);
	    System.out.println("File Name is : "+fileName);
	    

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook guru99Workbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class
	    System.out.println("File Extension is .xlsx");
	    guru99Workbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class
	    	System.out.println("File Extension is .xls");
	        guru99Workbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
	    System.out.println("Sheet Name : "+sheetName);

	    //Find number of rows in excel file

	    Integer rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	    
	    
	    //Create a loop over all the rows of excel file to read it
	  
	   /* System.out.println("Last Row Number : "+guru99Sheet.getLastRowNum());
	    System.out.println("First Row Number : "+guru99Sheet.getFirstRowNum());*/
	    Row row = null;
	    for (int i = 0; i < rowCount+1; i++) {

	        row = guru99Sheet.getRow(i);
	        //System.out.println("Last Cell Number : "+row.getLastCellNum());
	        //Create a loop to print cell values in a row
	        cellData = new LinkedList<String>();
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	        	// add to Map
	        	//System.out.println("Adding to MAP");
	        	//cell = row.getCell(j).getStringCellValue();
	        	cellData.add(row.getCell(j).getStringCellValue());
	        	//Print Excel data in console
	        	System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	        	System.out.println();
	        	//excelData.put(rowCount, cellData);
	        	//System.out.println("Added to MAP");
	        }
	        
	        excelData.put(rowCount, cellData);
	    }
	    //System.out.println("row.getRowNum() : "+row.getRowNum());
	    Object header = excelData.keySet().toArray()[0];
	    List<String> valueForheader = excelData.get(header);
		   //System.out.println("Header :"+header);
		   System.out.println("Value For header :"+valueForheader);
		   List <String> excelHeaderKeysList = new ArrayList<String>();
		   for (int i = 0; i < valueForheader.size(); i++){
			   System.out.println("Header Element : "+valueForheader.toArray()[i].toString());
			   excelHeaderKeysList.add(valueForheader.toArray()[i].toString());
		   }   
       System.out.println("Add Done!");
	    /*Iterator listIterator = cellData.iterator();
        System.out.println();
        while(listIterator.hasNext()){
        	String value = listIterator.next().toString();
        	System.out.println("VALUE IS : "+value);
        }*/
	    System.out.println("Added all the data into LinkedList");
	    
	    //Iterating thru the map
	    /*System.out.println("Iterating thru the map");
	    Iterator itr = excelData.keySet().iterator();
        while(itr.hasNext()){
        	Object keyIs =  itr.next();
        	System.out.println("Key is : "+keyIs);
        	String valueIs = excelData.get(keyIs).toString();
        	System.out.println("Value is : "+valueIs);
        }*/
	    
	    System.out.println("Read and Print COMPLETE");
	    return excelData;
	    }


}
