package com.testframework.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.seleniumdriver.gsd.core.logging.Log;
import com.seleniumdriver.gsd.core.logging.LoggingManager;
import com.testframework.core.InstantiateBrowser;
import com.testframework.core.CreateDictionary;

public class FetchDictionaryObject {
	
	//init();
	//createDictionaryObject();
	//storeDictionaryObject()
	static Logger logger = Logger.getLogger(Log.class.getName());
	static String filePath = "C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/log/Application.log";
	
public static void main (String...strings ) throws IOException{
	//@Test
	//public void fetchObject () throws IOException{
		
		try{
		File fileName= new File ("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/src/R8_Orange_TestData.xlsx");
		//Handler fileHandler = new FileHandler("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/log/Application.log", true);
		LoggingManager.getFileHandler(filePath);
		//System.out.println("Inside MAIN...");	
		logger.info( "Inside MAIN...");
		CreateDictionary createDictionaryObject = new CreateDictionary();
		//System.out.println("Creating New Dictionary Object");
		logger.info("Creating New Dictionary Object");
		HashMap oDict = createDictionaryObject.getDictionaryObject(fileName);
		//System.out.println("Creation Done!!.....Dictionary Object is now ready to utilize");
		logger.info("Creation Done!!.....Dictionary Object is now ready to utilize");
		UtilizeDictionaryObject utilizeDictionaryObject = new UtilizeDictionaryObject(oDict);
		logger.info("Opening the browser");
		InstantiateBrowser browser = new InstantiateBrowser();
		logger.info("Getting the screen shot");
		browser.getScreenShot();
		logger.info("Writing the screenshot to word document");
		browser.imageToDoc();
		logger.info("Generating Report....");
		browser.verifyTest();
		logger.info("Report Generation Complete!");
		logger.info("Exit from Main!!");
		}
		catch(Exception e){
			logger.info("Some Exception Occurred");
			//(logger.getLevel(), "Exception Occured");
			logger.info( e.getMessage());
			e.printStackTrace();
		}finally{
			//destroyDictionaryObject();
		}
	}

	}
