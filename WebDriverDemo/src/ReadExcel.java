import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.seleniumdriver.gsd.core.logging.Log;

public class ReadExcel {
	
	static Logger logger = Logger.getLogger(Log.class.getName());
	
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException{
		
		//Map dictionary = new TreeMap();
		 Map<String, String> ldapContent = new HashMap<String, String>();
		 List<String> header = new ArrayList<String>();
		 Properties properties = new Properties();
		 String ldap = null;
		 
		//LogManager.getLogManager().readConfiguration(new FileInputStream("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/lib/log4j.properties"));
		Handler fileHandler = new FileHandler("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/log/Application.log", 0, 5,true);
		fileHandler.setFormatter(new MyFormatter());
        //setting custom filter for FileHandler
        //fileHandler.setFilter(new MyFilter());
        logger.addHandler(fileHandler);
		//Create an object of File class to open xlsx file
	    File file =    new File(filePath+"\\"+fileName);
	    //logger.info("File name ");
	    logger.log(Level.INFO, fileName);
	    Level level = logger.getLevel();
	    System.out.println("Log Level : "+logger.getName());
	    System.out.println("File Path : "+file);
	    
	    //Create an object of FileInputStream class to read excel file
	    logger.info("Creating an object of FileInputStream class to read excel file" );
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook wb = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name
	    logger.info("Find the file extension by splitting file name in substring  and getting only extension name");
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    
	    //Check condition if the file is xlsx file
	    logger.info("Check condition if the file is xlsx or xls file");
	    if(fileExtensionName.equals(".xlsx")){
	    
	    	//If it is xlsx file then create object of XSSFWorkbook class
	    	logger.info("If it is xlsx file then create object of XSSFWorkbook class");
	    	wb = new XSSFWorkbook(inputStream);
	    }
	    //Check condition if the file is xls file
	    else if(fileExtensionName.equals(".xls")){
	        //If it is xls file then create object of XSSFWorkbook class
	    	logger.info("If it is xls file then create object of XSSFWorkbook class");
	    	wb = new HSSFWorkbook(inputStream);
	    }

	    //Read sheet inside the workbook by its name
	    logger.info("Read sheet inside the workbook by its name");
	    Sheet sh = wb.getSheet(sheetName);
	    //System.out.println("Sheet Name " +sh );
	    
	    //Find number of rows in excel file
	    logger.info("Find number of rows in excel file");
	    int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
	    System.out.println("Row Count : "+rowCount);
	    System.out.println();
	    //Create a loop over all the rows of excel file to read it
	   for (int i = 0; i < rowCount+1; i++) {
	         Row row = sh.getRow(0);
	       // System.out.println("Row : "+row);
	        String rowValue=row.getCell(i).getStringCellValue();
	        //System.out.println("Header : "+rowValue);
	        header.add(rowValue);
	   System.out.println("First Row : "+rowValue);
	   
	        
	        //Create a loop to print cell values in a row
	        for (int j = 1; j < row.getLastCellNum(); j++) {
	            //Print Excel data in console
	        	logger.info("Print Excel data in console");
	        	String cellValue = row.getCell(j).getStringCellValue();
	            //System.out.print(cellValue+"|| ");
	            
	            //dictionary = (Map) (dictionary.put(sh.getRow(i), row.getCell(j).getStringCellValue()));
	            //System.out.println("Cell Value : "+cellValue);
	            //System.out.println("Header Value : "+rowValue);
	            ldapContent.put(rowValue, cellValue);
	            //Start Saving into the Map Object 
	            //Map<String, String> ldapContent = new HashMap<String, String>();
	            

	            for (Map.Entry<String,String> entry : ldapContent.entrySet()) {
	            	System.out.println("ldapContent.entrySet()" +ldapContent.entrySet());
	                properties.put(entry.getKey(), entry.getValue());
	            }
	            properties.store(new FileOutputStream("data.properties"), null);
	            //Map Saved
	            
	            //System.out.println("row.getCell(j)" + row.getCell(j) );
	        }
	        //Read the Map
	        //ldapContent = new HashMap<String, String>();
	        //Properties properties = new Properties();
	        properties.load(new FileInputStream("data.properties"));
	        /*for (String key : properties.propertyNames()) {
	        	System.out.println("properties.stringPropertyNames() "+properties.propertyNames());
	        	 ldap = ldapContent.put(key, properties.get(key).toString());
	           
	        }*/
	        //System.out.println("End of lastCellNum");
	        //dictionary.put(sh.getRow(i), row.getCell(j).getStringCellValue());
	        
	        //System.out.println("Dictionary : "+ldap);
	        
	    }
	    //System.out.println("End of rowCount");
    }

	    

	    //Main function is calling readExcel function to read data from excel file

	    public static void main(String [] args) throws IOException{

	    //Create an object of ReadGuru99ExcelFile class
	    ReadExcel objExcelFile = new ReadExcel();

	    //Prepare the path of excel file
	    String filePath = System.getProperty("user.dir")+"\\src";

	    //Call read file method of the class to read data
	    objExcelFile.readExcel(filePath,"R8_Orange_TestData.xlsx","Sheet1");

	    }

}
