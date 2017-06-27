package com.testframework.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class FetchDictionaryObjectHelper {
	
	public XSSFWorkbook checkWorkbookType(String fileName, FileInputStream inputStream) throws IOException{
		//FileInputStream inputStream = new FileInputStream(fileName);
		XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class
		    System.out.println("File Extension is .xlsx");
		    workBook = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of XSSFWorkbook class
		    	System.out.println("File Extension is .xls");
		    	workBook = new XSSFWorkbook(inputStream);

		    }
		return workBook;
	}

}
